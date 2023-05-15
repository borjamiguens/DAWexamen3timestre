package org.example;

/**
 * Clase que contendrá los getters para obtener los emails y los saldos
 * , el constructor de la cuenta y metodos relacionados
 */
public class Cuenta {

    private final String email;
    public String getEmail() { return email; }

    private float saldo;
    public float getSaldo() { return saldo; }

    public Cuenta(String email, float saldo) {
        this.email = email;
        this.saldo = saldo;
    }

    /**
     * Método que se encarga de restar una cantidad al saldo de la cuenta
     *
     * @param cantidad Cantidad a restar
     * @return
     * @throws CantidadMayorQueSaldoException Excepción que salta cuando
     *                                        la cantidad a deducir el mayor que el saldo
     */
    public float restarASaldo(float cantidad) throws CantidadMayorQueSaldoException {
        if (cantidad > saldo) throw new CantidadMayorQueSaldoException();
        this.saldo -= cantidad;
        return cantidad;
    }

    /**
     * Método que se encarga de sumar una cantidad al saldo de la cuenta
     * @param cantidad  Cantidad a sumar
     */
    public void sumarASaldo(float cantidad) {
        this.saldo += cantidad;
    }

}
