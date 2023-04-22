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

public class Cupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(nullable = false)
    private int cantidadDcto;

    /////////////////////////////////////////RELACIONES//////////////////////////////////////

    @ManyToOne
    private Usuario usuario;

    @OneToOne
    private Compra compra;

    public Cupon(Estado estado, int cantidadDcto, Usuario usuario) {
        this.estado = estado;
        this.cantidadDcto = cantidadDcto;
        this.usuario = usuario;
    }
}
