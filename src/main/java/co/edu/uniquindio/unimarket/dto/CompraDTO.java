package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.model.FormaPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private int codigoUsuario;
    private FormaPago metodoPago;
    private List<DetalleCompraDTO> detalleCompraDTO;
}
