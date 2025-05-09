package creacion_api.rest_practica.Domain.EntityMedico.Consultas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consultas,Long> {

    boolean existsByMedicoIdAndFecha(Long medicoId, LocalDateTime fecha);


    boolean existsByPacienteIdAndFechaBetween( Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario);
}
