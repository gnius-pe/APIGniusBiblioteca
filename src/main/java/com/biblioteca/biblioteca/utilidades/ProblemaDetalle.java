package com.biblioteca.biblioteca.utilidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProblemaDetalle {
    private int status;
    private String title;
    private String detail;

    public ProblemaDetalle(int status, String title, String detail){
        this.status = status;
        this.title = title;
        this.detail = detail;
    }
}
