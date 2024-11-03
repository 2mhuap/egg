package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Rellenando {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese el tamaño del array: ");
    int length = sc.nextInt();
    System.out.print("Ingrese un número con el que quieras rellenar: ");
    int num = sc.nextInt();

    int[] a = new int[length];
    Arrays.fill(a, num);

    System.out.println(Arrays.toString(a));
    sc.close();
  }
}
