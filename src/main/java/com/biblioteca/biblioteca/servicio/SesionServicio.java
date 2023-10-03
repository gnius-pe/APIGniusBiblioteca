package com.biblioteca.biblioteca.servicio;


import com.biblioteca.biblioteca.modelo.usuario.Usuario;
import com.biblioteca.biblioteca.modelo.usuario.UsuarioBiblioteca;
import com.biblioteca.biblioteca.repositorio.SesionRepositorio;
import com.biblioteca.biblioteca.repositorio.UsuarioBibliotecaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionServicio{
    @Autowired
    private SesionRepositorio sesionRepositorio;

    @Autowired
    private UsuarioBibliotecaRepositorio usuarioBibliotecaRepositorio;

    public List<Usuario> getALlUsuario(){
        return sesionRepositorio.findAll();
    }

    public Usuario loginUsuario(String correo){
        return sesionRepositorio.loginUsuario(correo);
    }

    public boolean validaUsuarioBiblioteca(String codigo){
        try {
            UsuarioBiblioteca  usuarioBiblioteca = usuarioBibliotecaRepositorio.existsUsuarioDetalleByCodigo(codigo);
            return  usuarioBiblioteca.getCodigo().equals(codigo)? true : false;
        }catch (Exception e){
            System.out.println("error : " + e.getMessage());
            return false;
        }
    }

    public void guardarUsuario(Usuario usuario){
        sesionRepositorio.save(usuario);
    }

    public UsuarioBiblioteca guardarDetallesUsuario( UsuarioBiblioteca usuarioBiblioteca){
        return usuarioBibliotecaRepositorio.save(usuarioBiblioteca);
    }
}
