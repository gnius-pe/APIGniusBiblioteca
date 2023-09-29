package com.biblioteca.biblioteca.repositorio;

import com.biblioteca.biblioteca.modelo.DTO.tramite.SolicitudDocumentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudDocumentoRepositorio extends JpaRepository<SolicitudDocumentoDTO,Long> {

}
