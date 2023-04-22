package co.edu.uniquindio.unimarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@ToString
public class Moderador extends Persona implements Serializable {

    /////////////////////////////////////////RELACIONES//////////////////////////////////////

    @ToString.Exclude
    @OneToMany(mappedBy = "moderador")
    private List<ModeradorPdto> moderadorPdtos;

}
