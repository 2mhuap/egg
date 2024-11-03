package POO.Avanzado.DivisionSegura;

import java.util.Scanner;

public class Application {
  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    try {
      obtenerDenominador();
    } catch (ArithmeticException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      System.out.println("Cerrando");
      sc.close();
    }
  }

  private static int obtenerDenominador() throws ArithmeticException {
    System.out.print("Ingrese el número por el cual se desea dividir: ");
    int num = sc.nextInt();
    if (num == 0){
      throw new ArithmeticException("Dividiste por cero.");
    } 

    return num;
  }
}