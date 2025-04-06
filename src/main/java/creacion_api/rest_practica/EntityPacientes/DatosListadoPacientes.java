package creacion_api.rest_practica.EntityPacientes;

public record DatosListadoPacientes( Long id,String nombre, String email, String documentoIdentidad) {

    public DatosListadoPacientes (Pacientes pacientes){
   this(  pacientes.getId(),pacientes.getNombre(), pacientes.getEmail(), pacientes.getDocumentoIdentidad());
    }
}
