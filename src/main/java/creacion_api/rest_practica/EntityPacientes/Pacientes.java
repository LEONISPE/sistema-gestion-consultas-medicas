package creacion_api.rest_practica.EntityPacientes;


import creacion_api.rest_practica.Domain.EntityMedico.Direccion.Direccion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity(name = "paciente")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pacientes")
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String nombre;
private String email;
private String documentoIdentidad;
private String telefono;

@Embedded
Direccion direccion;

private Boolean activo;

    public Pacientes() {
    }


    public Pacientes(@Valid DatosRegistroPaciente datosRegistroPaciente) {
        this.nombre = datosRegistroPaciente.nombre();
        this.email= datosRegistroPaciente.email();
        this.documentoIdentidad = datosRegistroPaciente.documentoIdentidad();
        this.telefono = datosRegistroPaciente.telefono();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
        this.activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void actualizarDatos( DatosActualizadoPacientes datosActualizadoPacientes) {
        if (datosActualizadoPacientes.nombre() != null){
            this.nombre = datosActualizadoPacientes.nombre();
        }
        if (datosActualizadoPacientes.telefono() != null){
            this.telefono = datosActualizadoPacientes.telefono();
        }
        if (datosActualizadoPacientes.direccion() != null){
            direccion.actualizarDatos(datosActualizadoPacientes.direccion());
        }


    }
    public void desactivarPcientes(){
        this.activo = false;
    }
}
