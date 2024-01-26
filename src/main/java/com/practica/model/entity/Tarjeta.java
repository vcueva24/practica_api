package com.practica.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practica.utils.genera;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "tarjeta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Tarjeta {

    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idTarjeta;
    private String nroTarjeta;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonIgnore
    private Cliente cliente;


}
