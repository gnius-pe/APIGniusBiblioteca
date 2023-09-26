package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.usuario.Usuario;
import com.biblioteca.biblioteca.servicio.SesionServicio;
import com.biblioteca.biblioteca.utilidades.ProblemaDetalle;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genius/api/usuario/")
@Tag(name="Sesion", description = "API para la sesion en el sistema")
public class SesionController {

    @Autowired
    private SesionServicio sesionServicio;

    //@GetMapping("/all")
    private List<Usuario> getAllUserAlum(){
        return  sesionServicio.getALlUsuario();
    }


    

    @Operation(summary = "Obtener",description = "Retorna detalles del usuario", responses = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa", content = @Content( schema = @Schema(implementation = Message.class)))
    })
    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://127.0.0.1:5501","http://localhost:4200"})

    @GetMapping("/login/{correo}")
    public ResponseEntity<?> loginUsuario(@PathVariable String correo){
        Usuario usuario = sesionServicio.loginUsuario(correo);
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            int statusCode = HttpStatus.NOT_FOUND.value();
            String mensajeTitulo = "El correo no fue encontrado";
            String  mensajeDetalle = "El correo de '" + correo + "' no fue encontrado";
            ProblemaDetalle problemaDetalle =  new ProblemaDetalle(statusCode,mensajeTitulo,mensajeDetalle);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemaDetalle);
        }
    }
}
