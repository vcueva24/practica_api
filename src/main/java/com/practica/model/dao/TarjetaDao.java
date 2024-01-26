package com.practica.model.dao;

import com.practica.model.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface TarjetaDao extends JpaRepository<Tarjeta,Long> {
//    @Query("select count(*) from Tarjeta t where t.idcliente=?1")
//    void contar(Long id);
//long count();
}
