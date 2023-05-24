package co.edu.uniquindio.unimarket.repositories;

import co.edu.uniquindio.unimarket.model.Producto;
import org.springframework.data.domain.Pageable;
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

    @Query("select p from Producto p join Categoria c on p.codigo = c.producto.codigo where c.nombre " +
            "like concat( '%', :nombre, '%' ) and p.estado = 'APROBADO'")
    List<Producto> listarPdtosCategoria(String nombre);

    @Query("select p from Producto p where p.estado = :estado")
    List<Producto> listarProductosEstado(String estado);

    /*@Query("select p from Producto ")
    List<Producto> listarFavoritos(int codigoUser);*/

    @Query("select p from Producto p where p.precio between :precioMin and :precioMax")
    List<Producto> listarProductosPrecio(float precioMin, float precioMax);

    @Query("select p from Producto p join p.categorias c where c.codigo= :codigo order by p.precio asc")
    List<Producto> productosMenorPrecio(Integer codigo, Pageable page);

    @Query("select p from Producto p join p.categorias c where c.codigo= :codigo order by p.precio desc")
    List<Producto> productosMayorPrecio(Integer codigo, Pageable page);

}
