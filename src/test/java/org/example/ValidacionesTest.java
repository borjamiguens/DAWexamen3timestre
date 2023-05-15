package org.example;


import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionesTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void isEmailInValidoTest() {
        Assertions.assertEquals(false,Validaciones.isEmailInValido("borjamiguens@hotmail.com"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido("@hotmail.com"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido("borjamiguenshotmail@h.com"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido("borjamiguenshotmail@hotmail.c"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido(".borjamiguens@hotmail.com"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido("borjamiguens.@hotmail.com"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido("borjamiguens@-hotmail.com"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido("borjamiguens@hotmail.-com"));
        Assertions.assertEquals(true,Validaciones.isEmailInValido("borja..miguens@hotmail.com"));

    }
}