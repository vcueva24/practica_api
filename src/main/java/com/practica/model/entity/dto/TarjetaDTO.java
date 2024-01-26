package com.practica.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practica.model.entity.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TarjetaDTO {

    private Long id;
    private String idTarjeta;
    private String nroTarjeta;
    private String descripcion;
    private Cliente cliente;
}
