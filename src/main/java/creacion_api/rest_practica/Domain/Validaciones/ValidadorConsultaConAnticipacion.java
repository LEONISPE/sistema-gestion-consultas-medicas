package creacion_api.rest_practica.Domain.Validaciones;

import creacion_api.rest_practica.Domain.EntityMedico.Consultas.DatosReservasConsultas;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorConsultaConAnticipacion implements ValidadorDeConsultas{
    @Override
    public void validar(DatosReservasConsultas datos) {

var fechaConsulta = datos.fecha();
var fechaAhora = LocalDateTime.now();
var DiferenciaEnMinutos = Duration.between(fechaConsulta, fechaAhora).toMinutes();

if(DiferenciaEnMinutos < 30){
    throw new ValidacionExcepcion("tienen que ser 30 minutos por lo menos  de anticipacion");

}
    }
}
