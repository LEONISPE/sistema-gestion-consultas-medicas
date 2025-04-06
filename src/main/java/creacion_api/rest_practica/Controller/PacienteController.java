package creacion_api.rest_practica.Controller;


import creacion_api.rest_practica.EntityPacientes.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {


    @Autowired
    private PacienteRepository pacienteRepository;


    @PostMapping
    @Transactional
    public void agregarPacientes(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente) {
        pacienteRepository.save(new Pacientes(datosRegistroPaciente));

    }

    @GetMapping
    public Page<DatosListadoPacientes> mostrarPacientes(@PageableDefault(sort = {"nombre"}) Pageable pageable) {
 return pacienteRepository.findByActivoTrue(pageable).map(DatosListadoPacientes::new);
    }

    @PutMapping
    @Transactional
    public  void actualizarPacientes(@RequestBody @Valid DatosActualizadoPacientes datosActualizadoPacientes) {
Pacientes pacientes = pacienteRepository.getReferenceById(datosActualizadoPacientes.id());
pacientes.actualizarDatos(datosActualizadoPacientes);

    }

    @DeleteMapping("/{id}")
    public  void eliminarPacientes(@PathVariable Long id) {
        pacienteRepository.getReferenceById(id);
        Pacientes  pacientes = pacienteRepository.getReferenceById(id);
        pacientes.desactivarPcientes();
    }

}
