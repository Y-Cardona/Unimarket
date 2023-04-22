package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.vendedor.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where p.codigo = :codigo")
    Producto buscarProducto(int codigo);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.estado = 'APROBADO'")
    List<Producto> listarProductosNombre(String nombre);


}
