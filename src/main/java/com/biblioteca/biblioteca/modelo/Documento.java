package com.biblioteca.biblioteca.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;
    @Column(name = "nombre_documento")
    private String nombre;
    @Column(name = "area")
    private String area;
    @Column(name = "autor")
    private String autor;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "tipo_documento")
    private String tipo_documento;
    @Column(name = "url_img_presentacion")
    private String urlImg;
    @Column(name = "cantidad")
    private int cantidad;
}
