package com.practica.model.entity.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practica.model.entity.Tarjeta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDTO {

    private Long idCliente;

    private String nombreCliente;
    private String apellidoCliente;
    private String correo;
    private LocalDateTime fechaRegistro;
    private int totalTarjetas;
    private List<Tarjeta> tarjetaList;
}
