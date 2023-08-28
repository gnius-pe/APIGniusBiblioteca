package com.biblioteca.biblioteca.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long idUsuario;
    private String correo;
    private String password;

    public UsuarioDTO(Long idUsuario, String correo, String password){
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.password = password;
    }

}
