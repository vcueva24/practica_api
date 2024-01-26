package com.practica.controller;


import com.practica.model.entity.Cliente;
import com.practica.model.entity.Tarjeta;
import com.practica.model.entity.dto.TarjetaDTO;
import com.practica.service.Impl.TarjetaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TarjetaController {

    @Autowired
    private TarjetaServiceImpl tarjetaService;

    static String getAlphaNumericString(int n)
    {

        // choose a Character random from this String
	  /*String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	         + "0123456789"
	         + "abcdefghijklmnopqrstuvxyz"; */
        String AlphaNumericString ="0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    @PostMapping("tarjeta")
    public ResponseEntity<?> agregar(@RequestBody TarjetaDTO tarjetaDTO) throws URISyntaxException {

        Tarjeta tarjeta = Tarjeta.builder()
                .idTarjeta(getAlphaNumericString(19))
                .nroTarjeta(tarjetaDTO.getNroTarjeta())
                .descripcion(tarjetaDTO.getDescripcion())
                .cliente(tarjetaDTO.getCliente())
                .build();
        tarjetaService.guardarTarjeta(tarjeta);
        return ResponseEntity.ok(tarjeta);
    }


}
