package creacion_api.rest_practica.Domain.EntityMedico;


import creacion_api.rest_practica.Domain.EntityMedico.Direccion.Direccion;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "medico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private Boolean activo;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;


    public Medico() {
    }

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion =  new Direccion(datosRegistroMedico.direccion());
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Direccion getDirecion() {
        return direccion;
    }

    public void setDirecion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void actualizarDatos(DatosActualizadoMedico datosActualizadoMedico){
        if(datosActualizadoMedico.nombre() != null ){
    this.nombre = datosActualizadoMedico.nombre();
        }
        if(datosActualizadoMedico.documento() != null ){
            this.documento = datosActualizadoMedico.documento();
        }
        if(datosActualizadoMedico.direccion() != null ){
            this.direccion = direccion.actualizarDatos(datosActualizadoMedico.direccion());
        }
    }

    public  void desactivarMedico(){
        this.activo = false;
    }


}