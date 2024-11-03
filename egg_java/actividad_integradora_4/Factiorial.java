package actividad_integradora_4;

import java.util.Scanner;

public class Factiorial {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese un número entero: ");
    int num = sc.nextInt();

    int resultado = 1;
    do {
      resultado = resultado * num;
      num--;
    } while (num != 1);

    System.out.println("Factorial: " + resultado);
    sc.close();
  }
}
