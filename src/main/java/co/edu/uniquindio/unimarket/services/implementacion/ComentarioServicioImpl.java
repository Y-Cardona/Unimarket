package co.edu.uniquindio.unimarket.services.implementacion;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.model.Comentario;
import co.edu.uniquindio.unimarket.model.Producto;
import co.edu.uniquindio.unimarket.model.Usuario;
import co.edu.uniquindio.unimarket.repositories.ComentarioRepo;
import co.edu.uniquindio.unimarket.repositories.ProductoRepo;
import co.edu.uniquindio.unimarket.repositories.UsuarioRepo;
import co.edu.uniquindio.unimarket.services.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final ProductoRepo productoRepo;
    private final UsuarioRepo usuarioRepo;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = new Comentario();
        comentario.setMensaje(comentarioDTO.getMensaje());
        Producto p = productoRepo.buscarProducto(comentarioDTO.getCodigoProducto());
        comentario.setProducto(p);
        Usuario u = usuarioRepo.buscarUsuarioId(comentarioDTO.getCodigoUsuario());
        comentario.setUsuario(u);
        comentario.setFechComent(LocalDate.now());

        return comentarioRepo.save(comentario).getCodigo();
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) {
        List<Comentario> lista = comentarioRepo.listarComentario(codigoProducto);
        List<ComentarioGetDTO> comentarios = new ArrayList<>();
        for(Comentario c : lista){
            comentarios.add(convertir(c));
        }
        return null;
    }

    private ComentarioGetDTO convertir(Comentario comentario){

        ComentarioGetDTO comentarioDTO = new ComentarioGetDTO(
                comentario.getFechComent(),
                comentario.getMensaje(),
                comentario.getUsuario().getCodigo(),
                comentario.getProducto().getCodigo());

        return comentarioDTO;
    }

}
