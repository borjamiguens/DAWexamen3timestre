package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void getEmailTest() {
        Cuenta cuenta1=new Cuenta("borjamiguens@hotmail.com",1000);
        Cuenta cuenta2=new Cuenta("pacoperez@hotmail.com",2000);
        Assertions.assertEquals("borjamiguens@hotmail.com",cuenta1.getEmail());
        Assertions.assertEquals("pacoperez@hotmail.com",cuenta2.getEmail());
    }

    @Test
    void getSaldoTest() {
        Cuenta cuenta1=new Cuenta("borjamiguens@hotmail.com",1000);
        Cuenta cuenta2=new Cuenta("pacoperez@hotmail.com",2000);
        Assertions.assertEquals(1000,cuenta1.getSaldo());
        Assertions.assertEquals(2000,cuenta2.getSaldo());
    }

    @Test
    void restarASaldoTest() throws CantidadMayorQueSaldoException {
        Cuenta cuenta1=new Cuenta("borjamiguens@hotmail.com",1000);
        Cuenta cuenta2=new Cuenta("pacoperez@hotmail.com",2000);
        cuenta1.restarASaldo(500);
        Assertions.assertEquals(500,cuenta1.getSaldo());
        cuenta2.restarASaldo(500);
        Assertions.assertEquals(1500,cuenta2.getSaldo());





    }

    @Test
    void sumarASaldoTest() {
        Cuenta cuenta1=new Cuenta("borjamiguens@hotmail.com",1000);
        Cuenta cuenta2=new Cuenta("pacoperez@hotmail.com",2000);
        cuenta1.sumarASaldo(500);
        Assertions.assertEquals(1500,cuenta1.getSaldo());
        cuenta2.sumarASaldo(500);
        Assertions.assertEquals(2500,cuenta2.getSaldo());

    }
}