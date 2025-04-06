package creacion_api.rest_practica.EntityPacientes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Pacientes, Long> {

    Page<Pacientes> findByActivoTrue(Pageable pageable);


    @Query("""
            select p.activo
            from paciente p
            where
            p.id = :idPaciente
            """)
    boolean findActivoById(Long  idPaciente);
}
