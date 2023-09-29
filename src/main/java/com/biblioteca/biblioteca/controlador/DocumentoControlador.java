package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.DTO.tramite.SolicitudDocumentoDTO;
import com.biblioteca.biblioteca.modelo.Documento;
import com.biblioteca.biblioteca.servicio.DocuemntoServicio;
import com.biblioteca.biblioteca.servicio.SolicitudDocumentoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.ajp.Constants;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genius/api/documento")
@Tag(name = "Documentos", description = "API's para gestion documentario libro, tesis, articulos, etc.")
public class DocumentoControlador {

    @Autowired
    private DocuemntoServicio docuemntoServicio;

    @Autowired
    private SolicitudDocumentoServicio solicitudDocumentoServicio;

    @Operation(summary = "Obtener",description = "Retorna listado de documentos de tipo N(libro, tesis, articulo, etc)", responses ={
            @ApiResponse(responseCode = "200",description = "Operacion exitosa", content = @Content(schema = @Schema(implementation = Documento.class)))
    } )
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501"})
    @GetMapping("/todo")
    public List<Documento> obtenerTodoDocuento(){
        return docuemntoServicio.getTodoDocumento();
    }

    @GetMapping("/solicitudes")
    public List<SolicitudDocumentoDTO> getSolicituddes(){
        return solicitudDocumentoServicio.getSolicitudes();
    }

    @Operation(summary = "Solicitar", description = "Solicitar un documento N en la biblioteca ", responses = {
            @ApiResponse(responseCode = "201",description = "Solicitud realizado con exito", content = @Content(schema = @Schema(implementation = SolicitudDocumentoDTO.class)))
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502"})
    @PostMapping("/reservar")
    public ResponseEntity<String> reservarDocumento(@RequestBody SolicitudDocumentoDTO solicitudDocumentoDTO){
        System.out.println("entrada -> " + solicitudDocumentoDTO.toString());
        SolicitudDocumentoDTO solicitudDocumentoDTO1 = solicitudDocumentoServicio.reservarDocumeto(solicitudDocumentoDTO);
        if(solicitudDocumentoDTO1 != null){
            return ResponseEntity.ok("Solicitud de reserva creada con éxito.");
        }else {
            return ResponseEntity.badRequest().body("No se pudo crear la solicitud de reserva.");
        }
    }
}
