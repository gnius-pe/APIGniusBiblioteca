package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SesionRepositorio extends JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
    Usuario loginUsuario(String correo);
}
