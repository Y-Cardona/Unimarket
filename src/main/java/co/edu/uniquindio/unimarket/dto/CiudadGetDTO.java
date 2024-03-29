package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
public class CiudadGetDTO {

    @NotNull
    @NotBlank
    @Length(max = 60, message = "El nombre debe tener máximo 60 caracteres")
    private String nombre;

}
