package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentoRepositorio extends JpaRepository<Documento,Long> {
}
