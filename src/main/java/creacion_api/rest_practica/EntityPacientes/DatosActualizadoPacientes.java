package creacion_api.rest_practica.EntityPacientes;

import creacion_api.rest_practica.Domain.EntityMedico.Direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosActualizadoPacientes(@NotNull Long id,
                                        String nombre,
                                        String telefono,
                                        DatosDireccion direccion) {
}
