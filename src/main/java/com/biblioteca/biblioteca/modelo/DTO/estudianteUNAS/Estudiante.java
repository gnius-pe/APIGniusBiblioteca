package com.biblioteca.biblioteca.modelo.DTO.estudianteUNAS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estudiante {
    @JsonProperty("id_estudiante")
    private int idEstudiante;
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;

    @JsonProperty("apellido_materno")
    private  String apellidoMaterno;

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("email")
    private String email;

    @JsonProperty("creditos")
    private int creditos;

    @JsonProperty("semestre")
    private int semestre;

    @JsonProperty("promedio")
    private String promedio;

    @JsonProperty("url_foto")
    private String urlFoto;

    public double getPromedioAsDouble() {
        if (promedio != null && !promedio.isEmpty()) {
            return Double.parseDouble(promedio);
        }
        return 0.0;
    }
}
