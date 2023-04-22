package co.edu.uniquindio.unimarket.services.implementacion;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.model.Categoria;
import co.edu.uniquindio.unimarket.model.Estado;
import co.edu.uniquindio.unimarket.model.Producto;
import co.edu.uniquindio.unimarket.model.Usuario;
import co.edu.uniquindio.unimarket.repositories.ProductoRepo;
import co.edu.uniquindio.unimarket.repositories.UsuarioRepo;
import co.edu.uniquindio.unimarket.services.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.services.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    private final UsuarioRepo usuarioRepo;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setVendedor( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ) );
        producto.setImagenes( productoDTO.getImagenes() );
        producto.setCategorias( productoDTO.getCategorias() );
        producto.setEstado( Estado.PENDIENTE );
        producto.setFechCreacion(LocalDate.now() );
        producto.setFechLimite( LocalDate.now().plusDays(60) );

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception{
        Producto p = productoRepo.buscarProducto(codigoProducto);
        Usuario u = usuarioRepo.buscarUsuarioId(productoDTO.getCodigoVendedor());
        p.setCategorias(productoDTO.getCategorias());
        p.setNombre(productoDTO.getNombre());
        p.setDescripcion(productoDTO.getDescripcion());
        p.setUnidades(productoDTO.getUnidades());
        p.setPrecio(productoDTO.getPrecio());
        p.setImagenes(productoDTO.getImagenes());
        p.setVendedor(u);
        p.setCodigo(codigoProducto);

        return productoRepo.save(p).getCodigo();
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception{
        Producto p = productoRepo.buscarProducto(codigoProducto);
        p.setUnidades(unidades);
        p.setCodigo(codigoProducto);
        return productoRepo.save(p).getCodigo();
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado) throws Exception{
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception{
        productoRepo.delete(productoRepo.buscarProducto(codigoProducto))
        return codigoProducto;
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception{
        Producto p = productoRepo.buscarProducto(codigoProducto);
        return convertir(p);
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {

        List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getEstado(),
                producto.getFechLimite(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getPrecio(),
                producto.getVendedor().getCodigo(),
                producto.getImagenes(),
                producto.getCategorias()
        );

        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {

        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {
        return null;
    }
}
