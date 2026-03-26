
package crudveterinaria;
import java.time.LocalDateTime;

import crudveterinaria.utils.Rol;

public class Usuario {
    private int id;
    private String nombre; 
    private String correo;
    private String telefono;
    private String direccion;
    private Rol rol;
    private String contraseña;
    private Boolean activo;
    private LocalDateTime fechaRegistro;
    public Usuario() {}

    public Usuario(int id, String nombre, String correo, String telefono, String direccion, Rol rol, String contraseña, Boolean activo, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
        this.contraseña = contraseña;
        this.activo = true;
        this.fechaRegistro = fechaRegistro;
    }
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    //Metodos getters para acceder a los atributos del usuario
    public Rol getRol() {
        return rol;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getContraseña() {
        return contraseña;
    }
    public Boolean getActivo() {
        return activo;
    }
    public int getId() {
        return id;
    } 
    //Metodos setters para modificar los atributos del usuario
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    // Método toString para mostrar la información del usuario de forma legible
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Correo: " + correo + " | Teléfono: " + telefono + " | Dirección: " + direccion + " | Rol: " + rol.name();
    }

    
}