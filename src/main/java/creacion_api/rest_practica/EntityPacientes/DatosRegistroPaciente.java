package creacion_api.rest_practica.EntityPacientes;

import creacion_api.rest_practica.Domain.EntityMedico.Direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroPaciente(@NotBlank String nombre,
                                    @NotNull @Email
                                    String email,

                                    @NotBlank
                                    String telefono,
                                    @NotBlank
                                    String documentoIdentidad,
                                    @NotNull @Valid DatosDireccion direccion

                                    ) {



}
