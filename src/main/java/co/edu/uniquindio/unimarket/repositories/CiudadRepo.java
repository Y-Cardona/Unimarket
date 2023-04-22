package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    @Query("select c from Ciudad c")
    List<Ciudad> listarCiudades();

    @Query("select c from Ciudad c where c.nombre = :nombre")
    Ciudad buscarCiudad(String nombre);

}
