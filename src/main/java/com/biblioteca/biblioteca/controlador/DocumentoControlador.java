package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.Documento;
import com.biblioteca.biblioteca.servicio.DocuemntoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genius/api/documento")
@Tag(name = "Documentos", description = "API's para gestion documentario libro, tesis, articulos, etc.")
public class DocumentoControlador {

    @Autowired
    private DocuemntoServicio docuemntoServicio;

    @Operation(summary = "Obtener",description = "Retorna listado de documentos de tipo N(libro, tesis, articulo, etc)", responses ={
            @ApiResponse(responseCode = "200",description = "Operacion exitosa", content = @Content(schema = @Schema(implementation = Message.class)))
    } )
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501"})
    @GetMapping("/todo")
    public List<Documento> obtenerTodoDocuento(){
        return docuemntoServicio.getTodoDocumento();
    }

}
