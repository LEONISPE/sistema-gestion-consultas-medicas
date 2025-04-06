package creacion_api.rest_practica.Domain.EntityMedico.Consultas;


import creacion_api.rest_practica.Domain.EntityMedico.Medico;
import creacion_api.rest_practica.EntityPacientes.Pacientes;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Consulta")
@EqualsAndHashCode(of = "id")
@Table(name = "consultas")
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Pacientes pacientes;

    private LocalDateTime fecha;

    public Consultas( Medico medico, Pacientes pacientes, LocalDateTime fecha) {
        this.medico = medico;
        this.pacientes = pacientes;
        this.fecha = fecha;
    }

    public Consultas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
