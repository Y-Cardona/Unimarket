package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = :correo")
    Usuario buscarUsuario(String correo);

    @Query("select u from Usuario u where u.codigo = :cedula")
    Usuario buscarUsuarioId(int cedula);

}
