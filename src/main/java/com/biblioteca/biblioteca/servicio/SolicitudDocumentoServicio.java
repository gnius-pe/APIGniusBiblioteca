package com.biblioteca.biblioteca.servicio;

import com.biblioteca.biblioteca.modelo.DTO.tramite.SolicitudDocumentoDTO;
import com.biblioteca.biblioteca.repositorio.SolicitudDocumentoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudDocumentoServicio {
    @Autowired
    private SolicitudDocumentoRepositorio solicitudDocumentoRepositorio;

    public List<SolicitudDocumentoDTO> getSolicitudes(){
        return solicitudDocumentoRepositorio.findAll();
    }

    @Transactional
    public SolicitudDocumentoDTO guardarDocumento(SolicitudDocumentoDTO solicitudDocumentoDTO){
        System.out.println(solicitudDocumentoDTO.toString());
        return solicitudDocumentoRepositorio.save(solicitudDocumentoDTO);
    }

    public Optional<SolicitudDocumentoDTO> busquedaSolicitudPorID(Long id){
        return solicitudDocumentoRepositorio.findById(id);
    }
}
