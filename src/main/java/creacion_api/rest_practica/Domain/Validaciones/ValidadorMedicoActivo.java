package creacion_api.rest_practica.Domain.Validaciones;

import creacion_api.rest_practica.Domain.EntityMedico.Consultas.DatosReservasConsultas;
import creacion_api.rest_practica.Domain.EntityMedico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void validar(DatosReservasConsultas datos) {
if(datos.idMedico() == null){
    return;
}
var MedicoEstaActivo = medicoRepository.findByActivoById(datos.idMedico());
if(!MedicoEstaActivo){
    throw new ValidacionExcepcion("este medico esta inactivo ");
}
    }
}
