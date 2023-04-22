package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuponRepo extends JpaRepository<Cupon, Integer> {
    @Query("select c from Cupon c where c.codigo = :codigo")
    Cupon buscarCupon(int codigo);

    @Query("select c from Cupon c join Usuario u on c.usuario.codigo = u.codigo where u.codigo =:usuario " +
            "and c.estado = 'ACTIVO'")
    List<Cupon> listarCupones(int codigo);

}
