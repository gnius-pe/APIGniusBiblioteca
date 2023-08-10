package com.biblioteca.biblioteca.servicio;


import com.biblioteca.biblioteca.modelo.usuario.Usuario;
import com.biblioteca.biblioteca.repositorio.SesionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionServicio{
    @Autowired
    private SesionRepositorio sesionRepositorio;

    public List<Usuario> getALlUsuario(){
        return sesionRepositorio.findAll();
    }

    public Usuario loginUsuario(String correo){
        return sesionRepositorio.loginUsuario(correo);
    }
}
