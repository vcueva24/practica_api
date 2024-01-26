package com.practica.model.dao;

import com.practica.model.entity.Cliente;
import com.practica.model.entity.Tarjeta;
import com.practica.service.Impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TarjetaDaoTest {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    ClienteServiceImpl clienteService;
    @Test
    public void createCountQueryForSelectNewNotStartingWithSpace() throws Exception {
//        assertCountQuery("SELECT new com.acme.Foo(fooBar) FROM FooBar fooBar", "select count(fooBar) FROM FooBar fooBar");
        System.out.println("s");
    }

    private void assertCountQuery(String query) {
    }

    @Test
    void xd(){

        clienteDao.xd(1L);
    }
}
