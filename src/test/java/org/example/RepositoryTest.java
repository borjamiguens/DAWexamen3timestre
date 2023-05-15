package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void addTest() {
        ArrayList arraycuentas=new ArrayList();
        Cuenta cuenta1=new Cuenta("borjamiguens@hotmail.com",1000);
        Cuenta cuenta2=new Cuenta("pacoperez@hotmail.com",2000);
        Assertions.assertEquals(true,arraycuentas.add(cuenta1));
        Assertions.assertEquals(true,arraycuentas.add(cuenta2));


    }

    @Test
    void findByEmailTest() {
        ArrayList arraycuentas=new ArrayList();
        Cuenta cuenta1=new Cuenta("borjamiguens@hotmail.com",1000);
        Cuenta cuenta2=new Cuenta("pacoperez@hotmail.com",2000);
        arraycuentas.add(cuenta1);
        arraycuentas.add(cuenta2);



    }
}