package com.practica.controller;

import com.practica.model.dao.TarjetaDao;
import com.practica.model.entity.Cliente;
import com.practica.model.entity.Tarjeta;
import com.practica.model.entity.dto.ClienteDTO;
import com.practica.service.Impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    private TarjetaDao tarjetaDao;

    @PostMapping("cliente")
    public ResponseEntity<?> agregarCliente(@RequestBody Cliente cliente) throws URISyntaxException {
//        clienteService.guardar(Cliente.builder()
//                .nombreCliente(cliente.getNombreCliente())
//                .apellidoCliente(cliente.getApellidoCliente())
//                .correo(cliente.getCorreo())
//                .fechaRegistro(LocalDateTime.now()).build());
//        return ResponseEntity.created(new URI("/api/v1/cliente")).build();
        Cliente cliente1 = Cliente.builder()
                .nombreCliente(cliente.getNombreCliente())
                .apellidoCliente(cliente.getApellidoCliente())
                .correo(cliente.getCorreo())
                .fechaRegistro(LocalDateTime.now()).build();
        clienteService.guardar(cliente1);
        return ResponseEntity.ok(cliente1);
    }

    @GetMapping("clientes")
    public ResponseEntity<?> listarClientes() {
        List<ClienteDTO> clienteDTO = clienteService.listarClientes()
                .stream().map(cliente -> ClienteDTO.builder()
                        .idCliente(cliente.getIdCliente())
                        .nombreCliente(cliente.getNombreCliente())
                        .apellidoCliente(cliente.getApellidoCliente())
                        .correo(cliente.getCorreo())
                        .fechaRegistro(cliente.getFechaRegistro())
                        .tarjetaList(cliente.getTarjetaList())
                        .build()).toList();

//        Tarjeta userCount = tarjetaDao.countUsers(1L);
//        System.out.println(tarjetaDao.countUsers(userCount));
        return ResponseEntity.ok(clienteDTO);

    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){

        Optional<Cliente> optionalCliente = clienteService.findById(id);

        if(optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            ClienteDTO clienteDTO = ClienteDTO.builder()
                    .idCliente(cliente.getIdCliente())
                    .nombreCliente(cliente.getNombreCliente())
                    .correo(cliente.getCorreo())
                    .fechaRegistro(cliente.getFechaRegistro())
                    .apellidoCliente(cliente.getApellidoCliente())
                    .tarjetaList(cliente.getTarjetaList())
                    .build();

            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.badRequest().build();

    }



    @DeleteMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> eliminar(@PathVariable Long id){

        if(id != null){
            clienteService.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body("El parametro id se encuentra vacio");
    }
}
