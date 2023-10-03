package com.biblioteca.biblioteca.modelo.usuario;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", unique = true, nullable = false)
    private String nombreUsuario;

    @Column(name = "pasword_usuario", nullable = false)
    private String passwordUsuario;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "rol_usuario", nullable = false)
    private String rolUsuario;

    @Column(name = "id_usuario_biblioteca")
    private Integer idUsuarioBiblioteca;

    @ManyToOne
    @JoinColumn(name = "id_usuario_biblioteca", referencedColumnName = "id_usuario_biblioteca", insertable = false, updatable = false)
    private UsuarioBiblioteca usuarioBiblioteca;

    // Getters and setters

    public Usuario(){

    }

    public Usuario( String nombreUsuario, String passwordUsuario, String correo, String rolUsuario, Integer idUsuarioBiblioteca) {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.correo = correo;
        this.rolUsuario = rolUsuario;
        this.idUsuarioBiblioteca = idUsuarioBiblioteca;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Integer getIdUsuarioBiblioteca() {
        return idUsuarioBiblioteca;
    }

    public void setIdUsuarioBiblioteca(Integer idUsuarioBiblioteca) {
        this.idUsuarioBiblioteca = idUsuarioBiblioteca;
    }

    public UsuarioBiblioteca getUsuarioBiblioteca() {
        return usuarioBiblioteca;
    }

    public void setUsuarioBiblioteca(UsuarioBiblioteca usuarioBiblioteca) {
        this.usuarioBiblioteca = usuarioBiblioteca;
    }
}

