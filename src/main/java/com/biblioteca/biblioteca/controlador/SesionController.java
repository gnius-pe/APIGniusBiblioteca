package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.usuario.Usuario;
import com.biblioteca.biblioteca.servicio.SesionServicio;
import com.biblioteca.biblioteca.utilidades.ProblemaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genius/api/usuario/")
public class SesionController {

    @Autowired
    private SesionServicio sesionServicio;

    //@GetMapping("/all")
    private List<Usuario> getAllUserAlum(){
        return  sesionServicio.getALlUsuario();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
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
