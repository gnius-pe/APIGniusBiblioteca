package com.biblioteca.biblioteca.modelo.DTO.estudianteUNAS;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroEstudiante {

    private String codigo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String password;
    private String correo;

    // Constructor por defecto
    public RegistroEstudiante() {
    }

    // Constructor con todos los atributos
    public RegistroEstudiante(String codigo, String nombre, String apellidoPaterno, String apellidoMaterno, String password, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.password = password;
        this.correo = correo;
    }

    // Getters y setters (omitiendo para abreviar)

    @Override
    public String toString() {
        return "RegistroRequest{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
