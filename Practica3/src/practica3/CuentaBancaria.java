package practica3;

public class CuentaBancaria {

    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor con parámetros
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        setSaldo(saldoInicial); // mantiene validación
    }

    // Método para consultar información general
    public void consultarInformacion() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo actual: $" + saldo);
    }

    // Método para mostrar solo el saldo
    public void mostrarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

    // Sobrecarga del método depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito exitoso de $" + monto);
        } else {
            System.out.println("Monto invalido para deposito");
        }
    }

    public void depositar(int monto) {
        depositar((double) monto);
    }

    public void depositar(double monto, String referencia) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Deposito de $" + monto + " con referencia: " + referencia);
        } else {
            System.out.println("Monto invalido para deposito");
        }
    }

    // Método para retirar dinero
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso de $" + monto);
        } else {
            System.out.println("Saldo insuficiente o monto invalido");
        }
    }

    // Validación del saldo
    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("El saldo no puede ser negativo");
        }
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
