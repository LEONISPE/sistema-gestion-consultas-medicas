package creacion_api.rest_practica.Domain.EntityMedico.Consultas;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime fecha) {
    public DatosDetalleConsulta(Consultas consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPacientes().getId(),  consulta.getFecha());
    }
}
