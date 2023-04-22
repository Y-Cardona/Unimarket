package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@ToString
public class Usuario extends Persona implements Serializable {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(nullable = false)
    private LocalDate fechNac;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = false, length = 10)
    private String telefono;

    /////////////////////////////////////////RELACIONES//////////////////////////////////////

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @ToString.Exclude
    @ManyToMany(mappedBy = "usuarios")
    private List<Producto> productos;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productosList;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Cupon> cupones;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;

}
