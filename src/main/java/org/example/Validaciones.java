package org.example;

import java.util.regex.Pattern;

/**
 * Clase final de la cual no se instanciaran objeotos
 * encargadoa de las comprobaciones para validar un email
 */
public final class Validaciones {

    /**
     * Método constructor privado que no permite instanciar objetos
     */
    private Validaciones(){}

    // Patrón para verificar un email utilizando expresiones regulares

    /**
     * Método que se enacarga de comprobar la validación de un email conforme a un formato
     * valido mediante una funcion patrón
     */
    private static final String REGEX_EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    // El email será válido cuando se compone (en el siguiente orden) de
    //     - parte local (al menos una letra)
    //     - arroba
    //     - dominio (al menos dos letras, un punto y al menos otras dos letras)
    // Además, se permite el uso de los caracteres punto (".") y guión ("-") pero
    //     - el punto no puede estar al principio o al final de la parte local (antes de la arroba)
    //     ni al final del email
    //     - el guión no puede estar al principio o final de la parte de domino, ni después del punto
    //     - no puede haber dos puntos consecutivos.

    /**
     * Metodo que comprueba que el email introducido cumple el patron
     * @param email     Cadena de caracteres que se corresponde con el email introducido
     * @return          Booleano que es es false cuando el email cumple el patron y
     * true cuando no es válido
     */
    public static boolean isEmailInValido(String email) {
        return !Pattern.compile(REGEX_EMAIL_PATTERN).matcher(email).matches();
    }
}
