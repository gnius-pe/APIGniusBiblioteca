package com.biblioteca.biblioteca.modelo.DTO.estudianteUNAS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredencialUsuario {
    private String codigo;
    private String password;
    public CredencialUsuario() {
    }

    // Constructor con todos los atributos
    public CredencialUsuario(String codigo, String password) {
        this.codigo = codigo;
        this.password = password;
    }
}
