package bucles;

import java.util.Scanner;

/**
 * MenuInteractivo
 */
public class ContadorParesImpares {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int pares = 0;
    int impares = 0;
    boolean fin = false;
    while(!fin) {
      System.out.print("Ingrese un número que no sea 0, o 0 para terminar: ");
      int num = sc.nextInt();

      if (num == 0) {
        fin = true;
      } else if (num % 2 == 0){
        pares++;
      } else {
        impares++;
      }
      System.out.println("Número ingresado.");
    }

    System.out.println("Número de pares: " + pares);
    System.out.println("Número de impares: " + impares);
    sc.close();
  }
}