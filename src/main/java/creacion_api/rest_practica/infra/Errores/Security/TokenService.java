package creacion_api.rest_practica.infra.Errores.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import creacion_api.rest_practica.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;


    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al crear el token: " + exception.getMessage(), exception); // Mejor manejo de excepciones
        }
    }

    public String getSubject(String token) {
        if (token == null || token.isBlank()) {
            throw new SecurityException("Token nulo o vacío"); //Excepción más informativa
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("voll med")
                    .build();
            DecodedJWT jwt = verifier.verify(token); // Verifica la validez del token , firma fecha espiracion etc
            return jwt.getSubject();
        } catch (JWTVerificationException e) {
            System.err.println("Error al verificar el token: " + e.getMessage()); // Usa System.err para errores
            throw new SecurityException("Token inválido", e); // Excepción de seguridad con causa
        }
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
