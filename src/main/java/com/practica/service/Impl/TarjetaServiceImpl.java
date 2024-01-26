package com.practica.service.Impl;

import com.practica.model.dao.TarjetaDao;
import com.practica.model.entity.Tarjeta;
import com.practica.service.ITarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;


@Service
public class TarjetaServiceImpl implements ITarjeta {



    @Autowired
    private TarjetaDao tarjetaDao;
    @Override
    public void guardarTarjeta(Tarjeta tarjeta) {

//        int a = new Random().nextInt(100);
//        String s = Integer.toString(a);
//        Tarjeta tarjeta1 = new Tarjeta(
//                tarjeta.getId(),
//                getAlphaNumericString(19),
//                tarjeta.getNroTarjeta(),
//                tarjeta.getDescripcion(),
//                tarjeta.getClient()
//        );
         tarjetaDao.save(tarjeta);
    }

//    @Override
//    public Tarjeta count(Long id) {
//        tarjetaDao.contar(id);
//        return tarjetaDao.findById(id).get();
//    }


}
