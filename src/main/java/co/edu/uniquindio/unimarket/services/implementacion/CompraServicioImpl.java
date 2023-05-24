package co.edu.uniquindio.unimarket.services.implementacion;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.model.Producto;
import co.edu.uniquindio.unimarket.repositories.CompraRepo;
import co.edu.uniquindio.unimarket.services.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;
    @Override
    public int crearCompra(CompraDTO compraDTO) {

        return 0;
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }

    @Override
    public double totalVentas(LocalDate fecha) {
        return compraRepo.calcularTotalVentas(fecha);
    }

    @Override
    public List<ProductoGetDTO> listarPdtosComprados(Integer codigo) {
        List<ProductoGetDTO> pdtosComprados = new ArrayList<>();
        List<Producto> lista = compraRepo.listarPdtosComprados(codigo);
        for(Producto p : lista){
            pdtosComprados.add(convertir(p));
        }
        return null;
    }

    private ProductoGetDTO convertir(Producto producto){

        return new ProductoGetDTO(
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

    }
}
