package arrays;

import java.util.Scanner;

public class PromediandoElementos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese 4 números enteros:");
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    int num3 = sc.nextInt();
    int num4 = sc.nextInt();

    int[] a = {num1, num2, num3, num4};
    int suma = 0;
    for (int i = 0; i < a.length; i++) {
      suma += a[i];
    }
    System.out.println("Promedio: " + (double) suma / 4);

    sc.close();
  }
}
