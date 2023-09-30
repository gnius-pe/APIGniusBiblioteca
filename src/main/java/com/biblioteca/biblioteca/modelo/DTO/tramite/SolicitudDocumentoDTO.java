package com.biblioteca.biblioteca.modelo.DTO.tramite;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@Table(name = "documento_pedido")
public class SolicitudDocumentoDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento_pedido")
    private Long idDocumentoPedido;

    @Column(name = "fecha_reserva")
    private String fechaReserva;

    @Column(name = "estado")
    private String estado;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_documento")
    private Integer idDocumento;

    // Constructores, getters y setters aquí

    public SolicitudDocumentoDTO() {
    }

    public SolicitudDocumentoDTO(String fechaReserva, String estado, Integer idUsuario, Integer idDocumento) {
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idDocumento = idDocumento;
    }


    @Override
    public String toString() {
        return "Solicitud{" +
                "idDocumentoPedido=" + idDocumentoPedido +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", estado='" + estado + '\'' +
                ", idUsuario=" + idUsuario +
                ", idDocumento=" + idDocumento +
                '}';
    }
}