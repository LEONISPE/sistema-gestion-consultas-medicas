package creacion_api.rest_practica.Domain.EntityMedico;

import creacion_api.rest_practica.Domain.EntityMedico.Direccion.DatosDireccion;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroMedico(
        @NotBlank
String nombre,

@NotBlank
@Email
String email,
@NotBlank
String telefono,
@NotBlank
String documento,
@NotNull
Especialidad especialidad,
@NotNull
        DatosDireccion direccion


) {




}
