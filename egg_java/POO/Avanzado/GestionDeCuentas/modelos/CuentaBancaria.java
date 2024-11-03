package POO.Avanzado.GestionDeCuentas.modelos;

public class CuentaBancaria {
  private double saldoInicial;

  public CuentaBancaria(double saldoInicial) {
    this.saldoInicial = saldoInicial;
  }

  public void retirar(double cantidad) throws SaldoInsuficienteException {
    if (cantidad > saldoInicial){
      throw new SaldoInsuficienteException("Saldo insuficiente");
    } else {
      saldoInicial -= cantidad;
    }
  }
  
}
