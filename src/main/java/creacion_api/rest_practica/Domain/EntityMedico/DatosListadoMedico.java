package creacion_api.rest_practica.Domain.EntityMedico;

public record DatosListadoMedico( Long id,String nombre, String especialidad, String documento, String email) {

    public DatosListadoMedico(Medico medico){
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
