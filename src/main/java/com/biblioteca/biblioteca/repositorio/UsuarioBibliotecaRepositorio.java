package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.usuario.UsuarioBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioBibliotecaRepositorio extends JpaRepository<UsuarioBiblioteca,Long> {
    @Query("SELECT u FROM UsuarioBiblioteca u WHERE u.codigo = :codigo")
    public UsuarioBiblioteca existsUsuarioDetalleByCodigo(@Param("codigo") String codigo);
}
