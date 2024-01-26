package com.practica.service;

import com.practica.model.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ICliente {

    Cliente guardar(Cliente cliente);

    List<Cliente> listarClientes();

    void eliminarCliente(Long id);

    Optional<Cliente> findById(Long id);

    void obtener(Long id);

}
