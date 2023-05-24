package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Compra;
import co.edu.uniquindio.unimarket.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select sum(c.total) from Compra c where c.fechCompra = :fecha")
    Double calcularTotalVentas(LocalDate fecha);

    @Query("select distinct dc.producto from Compra c join c.detalleCompras dc where c.usuario.codigo = :codigo")
    List<Producto> listarPdtosComprados(Integer codigo);
}
