package creacion_api.rest_practica.Domain.EntityMedico.Direccion;

import org.antlr.v4.runtime.misc.NotNull;

public record DatosDireccion(
        @NotNull
         String calle,
        @NotNull
         String numero,
        @NotNull
         String distrito,
        @NotNull
         String complemento,
        @NotNull
         String ciudad
) {
}
