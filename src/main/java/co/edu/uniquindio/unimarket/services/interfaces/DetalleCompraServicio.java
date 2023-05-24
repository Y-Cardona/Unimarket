package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;

import java.util.List;

public interface DetalleCompraServicio {

    int registrarDetalle(DetalleCompraDTO detalle);

    List<DetalleCompraDTO> listarDetalles(int codigoCompra);

}
