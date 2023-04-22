package co.edu.uniquindio.unimarket.services.interfaces;

import co.edu.uniquindio.unimarket.dto.CiudadGetDTO;
import co.edu.uniquindio.unimarket.model.Ciudad;

import java.util.List;

public interface CiudadServicio {

    List<CiudadGetDTO> lsitarCiudades();

    Ciudad obtenerCiudad(CiudadGetDTO ciudad);

}
