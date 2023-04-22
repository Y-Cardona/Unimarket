package co.edu.uniquindio.unimarket.services.implementacion;

import co.edu.uniquindio.unimarket.dto.CiudadGetDTO;
import co.edu.uniquindio.unimarket.model.Ciudad;
import co.edu.uniquindio.unimarket.repositories.CiudadRepo;
import co.edu.uniquindio.unimarket.services.interfaces.CiudadServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CiudadServicioImpl implements CiudadServicio {

    private final CiudadRepo ciudadRepo;

    @Override
    public List<CiudadGetDTO> lsitarCiudades() {
        List<CiudadGetDTO> ciudades = new ArrayList<>();
        List<Ciudad> lista = ciudadRepo.listarCiudades();
        for(Ciudad c : lista){
            ciudades.add(convertir(c));
        }
        return null;
    }

    @Override
    public Ciudad obtenerCiudad(CiudadGetDTO ciudad) {
        return ciudadRepo.buscarCiudad(ciudad.getNombre());
    }

    private CiudadGetDTO convertir(Ciudad ciudad){

        CiudadGetDTO ciudadDTO = new CiudadGetDTO(
                ciudad.getNombre());

        return ciudadDTO;
    }

}
