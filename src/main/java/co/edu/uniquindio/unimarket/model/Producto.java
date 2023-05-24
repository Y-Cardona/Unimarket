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
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false)
    private int Unidades;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false)
    private int precio;

    @Column(nullable = false)
    private LocalDate fechLimite;

    @Column(nullable = false)
    private LocalDate fechCreacion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    /////////////////////////////////////////RELACIONES//////////////////////////////////////

    @ElementCollection
    @CollectionTable(name = "imgProducto")
    private List<String> imagenes;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Categoria> categorias;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "favorito")
    private List<Usuario> usuarios;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<ModeradorPdto> moderadorPdtos;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @ManyToOne
    private Usuario vendedor;

}
