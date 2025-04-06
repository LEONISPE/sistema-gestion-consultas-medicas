package creacion_api.rest_practica.Controller;


import creacion_api.rest_practica.Domain.EntityMedico.Direccion.DatosDireccion;
import creacion_api.rest_practica.Domain.EntityMedico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {


@Autowired
private MedicoRepository medicoRepository;

@PostMapping
public ResponseEntity<DatosRespuestasMedico> listarMedicos(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico, UriComponentsBuilder
                                                           uriComponentsBuilder) {
Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
DatosRespuestasMedico datosRespuestasMedico = new DatosRespuestasMedico(medico.getId(),
        medico.getEmail(), medico.getTelefono(), medico.getDocumento(), medico.getEspecialidad().toString(),
        new DatosDireccion(medico.getDirecion().getCalle(), medico.getDirecion().getDistrito(),
                medico.getDirecion().getNumero(), medico.getDirecion().getCiudad(), medico.getDirecion()
                .getComplemento()));
URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
return ResponseEntity.created(url).body(datosRespuestasMedico);
}

@GetMapping
public ResponseEntity<Page<DatosListadoMedico>> mostarMedicos(@PageableDefault  Pageable pajinacion){
return ResponseEntity.ok(medicoRepository.findByActivoTrue(pajinacion).map(DatosListadoMedico::new));

}


@PutMapping
@Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizadoMedico datosActualizadoMedico){

    Medico medico = medicoRepository.getReferenceById(datosActualizadoMedico.id());
medico.actualizarDatos(datosActualizadoMedico);
return ResponseEntity.ok(new DatosRespuestasMedico(medico.getId(),
        medico.getEmail(), medico.getTelefono(), medico.getDocumento(), medico.getEspecialidad().toString(),
        new DatosDireccion(medico.getDirecion().getCalle(), medico.getDirecion().getDistrito(),
                medico.getDirecion().getNumero(), medico.getDirecion().getCiudad(), medico.getDirecion()
                .getComplemento())));
}

@DeleteMapping("/{id}")
@Transactional
public ResponseEntity eliminarMedico(@PathVariable Long id){
Medico medico = medicoRepository.getReferenceById(id);
medico.desactivarMedico();
return ResponseEntity.noContent().build();
}

@GetMapping("/{id}")
public ResponseEntity buscarMedicosById(@PathVariable Long id){
Medico medico = medicoRepository.getReferenceById(id);
var DatosMedicos = new DatosRespuestasMedico(medico.getId(),
        medico.getEmail(), medico.getTelefono(), medico.getDocumento(), medico.getEspecialidad().toString(),
        new DatosDireccion(medico.getDirecion().getCalle(), medico.getDirecion().getDistrito(),
                medico.getDirecion().getNumero(), medico.getDirecion().getCiudad(), medico.getDirecion()
                .getComplemento()));
return ResponseEntity.ok(DatosMedicos);
}
}
