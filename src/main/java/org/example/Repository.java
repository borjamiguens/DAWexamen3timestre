package org.example;

import java.util.*;

/**
 * Clase repository que hace las funciones de bases de datos
 * mediante la utilización de un ArrayList de cuentas de correo electronico
 */
public class Repository {

    private final List<Cuenta> baseDeDatos = new ArrayList<>();

    /**
     * Método que añade una cuenta al arraylist
     * @param cuenta    Cuenta que se va añadir al Arraylist
     * @return          Booleano que es true si añade la cuenta correctamente
     */
    public boolean add(Cuenta cuenta) {
        if (findByEmail(cuenta.getEmail())!=null) return false;
        else return baseDeDatos.add(cuenta);
    }

    /**
     * Método que busca una cuenta en funcion del email
     * @param email     email del cual quiero saber la cuenta
     * @return          Devuelve una cuenta si alguna corresponde con
     *                  un email válido
     */
    public Cuenta findByEmail(String email) {
        return baseDeDatos.stream().filter(e -> e.getEmail().equals(email)).findAny().orElse(null);
    }

}
