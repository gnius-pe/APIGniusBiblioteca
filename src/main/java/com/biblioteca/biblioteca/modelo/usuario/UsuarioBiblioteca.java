package com.biblioteca.biblioteca.modelo.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "usuario_biblioteca")
public class UsuarioBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_biblioteca")
    private Long idUsuarioBiblioteca;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "numero_celular")
    private String numeroCelular;

    @Column(name = "url_foto_perfil")
    private String urlFotoPerfil;

    @Column(name = "descripcion")
    private String descripcion;

    // Getters and setters

    public Long getIdUsuarioBiblioteca() {
        return idUsuarioBiblioteca;
    }

    public void setIdUsuarioBiblioteca(Long idUsuarioBiblioteca) {
        this.idUsuarioBiblioteca = idUsuarioBiblioteca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getUrlFotoPerfil() {
        return urlFotoPerfil;
    }

    public void setUrlFotoPerfil(String urlFotoPerfil) {
        this.urlFotoPerfil = urlFotoPerfil;
    }
}