package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {
}
