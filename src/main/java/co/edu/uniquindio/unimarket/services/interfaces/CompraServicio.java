package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;

import java.time.LocalDate;
import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO);

    List<CompraGetDTO> listarCompras(int codigoUsuario);

    CompraGetDTO obtenerCompra(int codigoCompra);

    double totalVentas(LocalDate fecha);

    List<ProductoGetDTO> listarPdtosComprados(Integer codigo);

}
