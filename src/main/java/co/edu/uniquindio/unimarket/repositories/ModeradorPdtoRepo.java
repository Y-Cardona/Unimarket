package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.ModeradorPdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorPdtoRepo extends JpaRepository<ModeradorPdto, Integer> {
}
