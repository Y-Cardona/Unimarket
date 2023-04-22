package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {

    @Query("select c from Comentario c where c.producto.codigo = :codigo")
    List<Comentario> listarComentario(int codigo);

}
