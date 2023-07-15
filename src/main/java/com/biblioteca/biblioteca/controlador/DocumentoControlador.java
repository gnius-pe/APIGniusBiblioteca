package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.Documento;
import com.biblioteca.biblioteca.servicio.DocuemntoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genius/api/documento")
public class DocumentoControlador {

    @Autowired
    private DocuemntoServicio docuemntoServicio;

    @GetMapping("/todo")
    public List<Documento> obtenerTodoDocuento(){
        return docuemntoServicio.getTodoDocumento();
    }

    @GetMapping("/test")
    public String funciona(){
        return "holaaa";
    }
}
