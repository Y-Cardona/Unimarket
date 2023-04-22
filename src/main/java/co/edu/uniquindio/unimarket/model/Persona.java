package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * En la clase Persona se crean los atributos principales que sera heredadas por las otras clases.
 * Integer codigo
 * String nombre
 * String email
 * String password
 */

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
@ToString
public class Persona implements Serializable {

    @Id
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 100)
    @Length(max = 100)
    @NotBlank
    private String nombre;

    @Column(nullable = false, unique = true)
    @Email(message = "Ingrese un Email Válido")
    @NotBlank
    private String email;

    @Column(nullable = false, length = 50)
    @NotBlank
    //@JsonIgnore
    private String password;

}

