package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.DTO.tramite.EstadoRequest;
import com.biblioteca.biblioteca.modelo.DTO.tramite.SolicitudDocumentoDTO;
import com.biblioteca.biblioteca.modelo.Documento;
import com.biblioteca.biblioteca.servicio.DocuemntoServicio;
import com.biblioteca.biblioteca.servicio.SolicitudDocumentoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502"})
    @GetMapping("/todo")
    public List<Documento> obtenerTodoDocuento(){
        return docuemntoServicio.getTodoDocumento();
    }

    @Operation(summary = "Documentos solicitados", description = "Retorna todas las solicitudes", responses = {
            @ApiResponse(responseCode = "200",description = "Operacion exitosa", content = @Content(schema = @Schema(implementation = SolicitudDocumentoDTO.class)))
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502"})
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
        SolicitudDocumentoDTO solicitudDocumentoDTO1 = solicitudDocumentoServicio.guardarDocumento(solicitudDocumentoDTO);
        if(solicitudDocumentoDTO1 != null){
            return ResponseEntity.ok("Solicitud de reserva creada con éxito.");
        }else {
            return ResponseEntity.badRequest().body("No se pudo crear la solicitud de reserva.");
        }
    }

    @Operation(summary = "actualizar estado",description = "Cambia el estado del documento solicitado", responses = {
            @ApiResponse(responseCode = "200", description = "Actualización realizada con éxito", content = @Content(schema = @Schema(implementation = EstadoRequest.class))),
            @ApiResponse(responseCode = "404", description = "Documento no encontrado"),
            @ApiResponse(responseCode = "400", description = "Solicitud de actualización inválida")
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502"})
    @PatchMapping("/{idDocumentoPedido}/set-estado")
    public ResponseEntity<String> aceptacionSolicitudDocumento (@PathVariable Long idDocumentoPedido, @RequestBody EstadoRequest estadoRequest){
        Optional<SolicitudDocumentoDTO> documentoPedido = solicitudDocumentoServicio.busquedaSolicitudPorID(idDocumentoPedido);
        if(idDocumentoPedido != null && estadoRequest.getEstado() != null){
            documentoPedido.get().setEstado(estadoRequest.getEstado());
            solicitudDocumentoServicio.guardarDocumento(documentoPedido.get());
            return ResponseEntity.ok("Estado de documento actualizado");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "nuevo documento",description = "se agregara un nuevo docuemnto de cualquier tipo",responses = {
            @ApiResponse(responseCode = "200",description = "Operacion exitosa", content = @Content(schema = @Schema(implementation = Documento.class)))
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200","http://127.0.0.1:5502"})
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarDocuemnto(@RequestBody Documento documento){
        try {
            Documento nuevoDocumento = docuemntoServicio.agregarDocumento(documento);
            return ResponseEntity.status(HttpStatus.CREATED).body("Documento agregado cone xito. ID" + nuevoDocumento.getIdDocumento());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error alñ agregar documento" + e.getMessage());
        }
    }
}
