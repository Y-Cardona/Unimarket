package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private int precioProducto;

    /////////////////////////////////////////RELACIONES//////////////////////////////////////

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Compra compra;
}
