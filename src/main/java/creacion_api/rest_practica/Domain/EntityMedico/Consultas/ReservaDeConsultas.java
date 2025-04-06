package creacion_api.rest_practica.Domain.EntityMedico.Consultas;

import creacion_api.rest_practica.Domain.EntityMedico.Medico;
import creacion_api.rest_practica.Domain.EntityMedico.MedicoRepository;
import creacion_api.rest_practica.Domain.Validaciones.ValidacionExcepcion;
import creacion_api.rest_practica.Domain.Validaciones.ValidadorDeConsultas;
import creacion_api.rest_practica.EntityPacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaDeConsultas {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorDeConsultas> validadores;

    public DatosDetalleConsulta reservar(DatosReservasConsultas datos){

        if(!pacienteRepository.existsById(datos.idPaciente())){
            throw new ValidacionExcepcion("No existe un paciente con el id informado");
        }

        if(datos.idMedico() != null && !medicoRepository.existsById(datos.idMedico())){
            throw new ValidacionExcepcion("No existe un médico con el id informado");
        }

        //validaciones
        validadores.forEach(v -> v.validar(datos));

        var medico = elegirMedico(datos);
        if(medico == null){
            throw new ValidacionExcepcion("No existe un médico disponible en ese horario");
        }
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        var consulta = new Consultas( medico, paciente, datos.fecha());
        consultaRepository.save(consulta);
        return new DatosDetalleConsulta(consulta);
    }

    private Medico elegirMedico(DatosReservasConsultas datos) {
        if(datos.idMedico() != null){
            return medicoRepository.getReferenceById(datos.idMedico());
        }
        if(datos.especialidad() == null){
            throw new ValidacionExcepcion("Es necesario elegir una especialidad cuando no se elige un médico");
        }

        return medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(datos.especialidad(), datos.fecha());
    }
}

