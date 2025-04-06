package creacion_api.rest_practica.Domain.EntityMedico;

import creacion_api.rest_practica.Domain.EntityMedico.Direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizadoMedico(@NotNull Long id, String nombre, String documento, DatosDireccion direccion) {
}
