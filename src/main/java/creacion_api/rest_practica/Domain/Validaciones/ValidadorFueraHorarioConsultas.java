package creacion_api.rest_practica.Domain.Validaciones;

import creacion_api.rest_practica.Domain.EntityMedico.Consultas.DatosReservasConsultas;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorFueraHorarioConsultas implements ValidadorDeConsultas{
    @Override
    public void validar(DatosReservasConsultas datos) {

         var FechaConsulta= datos.fecha();
         var domingo = FechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
         var HorarioAntesAperturaClinica = FechaConsulta.getHour() < 7;
        var HorarioDespuesAperturaClinica = FechaConsulta.getHour() < 18;

        if(domingo || HorarioAntesAperturaClinica || HorarioDespuesAperturaClinica){
            throw new ValidacionExcepcion("fecha fuera del horario de atendimiento");
        }

    }
}
