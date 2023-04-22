package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private LocalDate fechCompra;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaPago medioPago;

    @Column(nullable = false)
    private int total;

    /////////////////////////////////////////RELACIONES//////////////////////////////////////

    @ToString.Exclude
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompras;

    @ManyToOne
    private Usuario usuario;

    @ToString.Exclude
    @OneToOne(mappedBy = "cupon")
    private Cupon cupon;
}
