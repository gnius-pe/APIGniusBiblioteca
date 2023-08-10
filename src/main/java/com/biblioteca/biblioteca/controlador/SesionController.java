package com.biblioteca.biblioteca.controlador;

import com.biblioteca.biblioteca.modelo.usuario.Usuario;
import com.biblioteca.biblioteca.servicio.SesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/login/{correo}")
    public Usuario loginUsuario(@PathVariable String correo){
        return sesionServicio.loginUsuario(correo);
    }
}
