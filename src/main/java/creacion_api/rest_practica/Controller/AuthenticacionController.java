package creacion_api.rest_practica.Controller;

import creacion_api.rest_practica.Usuario.DatosAuthenticacionUsuario;
import creacion_api.rest_practica.Usuario.Usuario;
import creacion_api.rest_practica.infra.Errores.Security.DatosJWTtoken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import creacion_api.rest_practica.infra.Errores.Security.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticacionController {

    @Autowired
    private TokenService tokenservice;

    @Autowired
    private AuthenticationManager authenticationManager;




    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAuthenticacionUsuario datosAutenticacionUsuario) {
        Authentication Authtoken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.clave());
        var UsusarioAutenticado = authenticationManager.authenticate(Authtoken);
        var JWTtoken = tokenservice.generarToken((Usuario) UsusarioAutenticado.getPrincipal());
        return ResponseEntity.ok( new DatosJWTtoken(JWTtoken));

    }
}
