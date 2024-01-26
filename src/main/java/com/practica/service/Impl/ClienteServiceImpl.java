package com.practica.service.Impl;

import com.practica.model.dao.ClienteDao;
import com.practica.model.entity.Cliente;
import com.practica.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ICliente {

    @Autowired
    private ClienteDao clienteDao;
    @Override
    public Cliente guardar(Cliente cliente) {
//        Cliente cli = new Cliente(
//                cliente.getIdCliente(),
//                cliente.getNombreCliente(),
//                cliente.getApellidoCliente(),
//                cliente.getCorreo(),
//                LocalDateTime.now(),
//                cliente.getTarjetas()
//        );
        return clienteDao.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteDao.findById(id);
    }

    @Override
    public void obtener(Long id) {
        clienteDao.findById(id);

    }


}
