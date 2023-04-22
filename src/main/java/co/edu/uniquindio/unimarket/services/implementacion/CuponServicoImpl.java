package co.edu.uniquindio.unimarket.services.implementacion;

import co.edu.uniquindio.unimarket.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.model.Cupon;
import co.edu.uniquindio.unimarket.model.Estado;
import co.edu.uniquindio.unimarket.model.Usuario;
import co.edu.uniquindio.unimarket.repositories.CuponRepo;
import co.edu.uniquindio.unimarket.services.interfaces.CuponServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CuponServicoImpl implements CuponServicio {

    private final CuponRepo cuponRepo;

    public int crearCupon(Usuario usuario){
        Cupon cupon = new Cupon(Estado.ACTIVO,20,usuario);
        return cuponRepo.save(cupon).getCodigo();
    }

    public String cambiarEstado(CuponGetDTO cupon){
        Cupon buscado = cuponRepo.buscarCupon(Integer.valueOf(cupon.getCodigo()));
        buscado.setEstado(Estado.INACTIVO);
        return cuponRepo.save(buscado).getEstado().toString();
    }

    public List<CuponGetDTO> listarCupones(int usuario){
        List<CuponGetDTO> respuesta = new ArrayList<>();
        List<Cupon> cupones = cuponRepo.listarCupones(usuario);
        for(Cupon c : cupones){
            respuesta.add(convertir(c));
        }
        return respuesta;
    }

    private CuponGetDTO convertir(Cupon cupon){
        CuponGetDTO cuponDTO = new CuponGetDTO(
                ""+cupon.getCodigo());

        return cuponDTO;
    }


}
