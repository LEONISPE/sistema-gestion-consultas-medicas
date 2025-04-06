package creacion_api.rest_practica.Domain.Validaciones;

import creacion_api.rest_practica.Domain.EntityMedico.Consultas.ConsultaRepository;
import creacion_api.rest_practica.Domain.EntityMedico.Consultas.DatosReservasConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorMedicoConOtrasConsultasMismoHorario implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    @Override
    public void validar(DatosReservasConsultas datos) {
var MedicoTieneOtraConsultaMismoHorario = repository. existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());
if (MedicoTieneOtraConsultaMismoHorario) {
    throw new ValidacionExcepcion("Medico tiene otras consultas en esa fecha");
}
    }
}
