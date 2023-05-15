package org.example;

/**
 * Clase controller que recibe las peticiones
 */
public class Controller {
    private final org.example.Repository repository = new org.example.Repository();

    private static final float MIN_CANTIDAD_TRANSACCION = 0.50f;
    private static final float MAX_CANTIDAD_TRANSACCION = 500f;

    /**
     * Método para registrar una cuenta
     * @param emailRegistro     email asociado a la cuenta
     * @param cantidadInicial   cantidad inicial de la cuenta
     * @return
     * @throws org.example.CantidadInicialMenorOIgualQueCeroException
     *          Excepción que salta cuando la cantidad inicial a ingresar
     *          es cero o negativa
     */
    public boolean registrarCuenta(String emailRegistro, float cantidadInicial)
            throws org.example.CantidadInicialMenorOIgualQueCeroException {
        if (cantidadInicial <= 0) throw new org.example.CantidadInicialMenorOIgualQueCeroException();
        return repository.add(new org.example.Cuenta(emailRegistro, cantidadInicial));
    }

    /**
     * Método que permite la consulta de saldo
     * @param email
     * @return
     * @throws CuentaNoExisteException  Excepcion que salta cuando se quiere consultar
     *                                  una cuenta que no existe
     */
    public float consultarSaldo(String email) throws CuentaNoExisteException {
        Cuenta cuenta = repository.findByEmail(email);
        if (cuenta==null) throw new CuentaNoExisteException();
        else return cuenta.getSaldo();
    }

    /**
     * Método que permite el ingreso de dinero
     * @param emailOrigen
     * @param cantidad
     * @throws CantidadInicialMenorOIgualQueCeroException
     * @throws CantidadInIntervaloValidoException
     */
    public void ingresarDinero(String emailOrigen, float cantidad)
            throws CantidadInicialMenorOIgualQueCeroException, CantidadInIntervaloValidoException {
        if (cantidad <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        if ((cantidad < MIN_CANTIDAD_TRANSACCION) || (cantidad > MAX_CANTIDAD_TRANSACCION))
            throw new CantidadInIntervaloValidoException();
        repository.findByEmail(emailOrigen).sumarASaldo(cantidad);
    }

    /**
     * Método que permite la extracción de dinero de la cuenta
     * @param emailDestino
     * @param cantidad
     * @throws CantidadInicialMenorOIgualQueCeroException
     * @throws CantidadInIntervaloValidoException
     * @throws CantidadMayorQueSaldoException
     */
    public void sacarDinero(String emailDestino, float cantidad)
            throws CantidadInicialMenorOIgualQueCeroException, CantidadInIntervaloValidoException,
            CantidadMayorQueSaldoException {
        if (cantidad <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        if ((cantidad < MIN_CANTIDAD_TRANSACCION) || (cantidad > MAX_CANTIDAD_TRANSACCION))
            throw new CantidadInIntervaloValidoException();
        repository.findByEmail(emailDestino).restarASaldo(cantidad);
    }


}
