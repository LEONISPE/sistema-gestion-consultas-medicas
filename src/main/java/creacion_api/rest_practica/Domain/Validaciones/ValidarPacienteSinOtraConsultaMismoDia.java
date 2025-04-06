package creacion_api.rest_practica.Domain.Validaciones;

import creacion_api.rest_practica.Domain.EntityMedico.Consultas.ConsultaRepository;
import creacion_api.rest_practica.Domain.EntityMedico.Consultas.DatosReservasConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteSinOtraConsultaMismoDia implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository consultaRepository;
    @Override
    public void validar(DatosReservasConsultas datos) {

        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario= datos.fecha().withHour(18);
        var PacienteTieneOtraConsultaMismoDia = consultaRepository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);
        if(PacienteTieneOtraConsultaMismoDia){
            throw new ValidacionExcepcion("ya este paciente tiene otra consulta este dia");
        }
    }
}
