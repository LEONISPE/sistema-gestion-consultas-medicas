package creacion_api.rest_practica.Domain.EntityMedico;

import creacion_api.rest_practica.Domain.EntityMedico.Direccion.DatosDireccion;

public record DatosRespuestasMedico(Long id , String nombre , String email, String telefono,
                                    String documento , DatosDireccion direccion) {
}
