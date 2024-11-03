package POO.Avanzado.GestionDeCuentas;

import POO.Avanzado.GestionDeCuentas.modelos.CuentaBancaria;
import POO.Avanzado.GestionDeCuentas.modelos.SaldoInsuficienteException;

public class Application {
  public static void main(String[] args) {
    CuentaBancaria cb = new CuentaBancaria(100);

    try {
      cb.retirar(120);
      System.out.println("S/120 retirado");
    } catch (SaldoInsuficienteException e) {
      System.out.println(e.getMessage() + " para retirar S/120");
    }

    try {
      cb.retirar(90);
      System.out.println("S/90 retirado");
    } catch (SaldoInsuficienteException e) {
      System.out.println(e.getMessage() + " para retirar S/90");
    }
  }
}
