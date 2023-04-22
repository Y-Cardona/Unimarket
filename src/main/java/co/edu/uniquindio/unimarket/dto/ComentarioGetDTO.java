package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO {

    private LocalDate fecha;

    private String mensaje;

    private int codigoUsuario;

    private int codigoProducto;

}
