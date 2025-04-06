package creacion_api.rest_practica.Domain.Validaciones;

import creacion_api.rest_practica.Domain.EntityMedico.Consultas.DatosReservasConsultas;
import creacion_api.rest_practica.EntityPacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteActivo  implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public void validar(DatosReservasConsultas datos) {
var PacienteActivo = pacienteRepository.findActivoById(datos.idPaciente());

if(!PacienteActivo){
    throw new ValidacionExcepcion("Paciente inactivo");
}
    }
}
