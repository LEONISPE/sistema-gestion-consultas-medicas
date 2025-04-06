package creacion_api.rest_practica.Domain.EntityMedico.Consultas;

import creacion_api.rest_practica.Domain.EntityMedico.Especialidad;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosReservasConsultas(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime fecha,
        Especialidad especialidad
) {
}
