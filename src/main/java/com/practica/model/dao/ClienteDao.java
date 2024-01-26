package com.practica.model.dao;

import com.practica.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteDao extends JpaRepository<Cliente,Long> {
//@Query(value = "select count(DISTINCT Tarjeta.id) as Total from Tarjeta join Cliente on Tarjeta.cliente = ?1", nativeQuery = true)
@Query(value = "select count(*) from Tarjeta where idCliente =?1", nativeQuery = true)
//long contarT(Long id);
    List<Cliente> xd(@Param("idCliente") Long id);


}
