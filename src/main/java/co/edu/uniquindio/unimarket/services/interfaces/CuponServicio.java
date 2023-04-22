package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CuponGetDTO;
import co.edu.uniquindio.unimarket.model.Usuario;

import java.util.List;

public interface CuponServicio {

    int crearCupon (Usuario usuario);

    String cambiarEstado(CuponGetDTO cupon);

    List<CuponGetDTO> listarCupones(int usuario);

}
