package arrays;

import java.util.Scanner;

public class BuscandoElemento {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] a = {1,2,3};

    System.out.print("Ingrese un número entero: ");
    int num = sc.nextInt();
    boolean cero = a[0] == num;
    boolean uno = a[1] == num;
    boolean dos = a[2] == num;

    if (cero || uno || dos) {
      System.out.println("El número está presente en el array ");
    } else {
      System.out.println("El número NO está presente en el array ");
    }

    sc.close();
  }
}
