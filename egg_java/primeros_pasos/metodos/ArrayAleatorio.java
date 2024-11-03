package metodos;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAleatorio {

  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Ingrese el tamaño del array: ");
    int length = sc.nextInt();
    System.out.print("Ingrese el mínimo del rango de números posibles: ");
    int min = sc.nextInt();
    System.out.print("Ingrese el máximo del rango de números posibles: ");
    int max = sc.nextInt();

    try {
      int[] a = new int[length];
      for (int i = 0; i < length; i++) {
        a[i] = numeroAleatorio(min, max);
      }
      System.out.println(Arrays.toString(a));
    } catch(Exception e) {
      System.out.println("Tamaño inválido.");
    }
    sc.close();
  }

  public static int numeroAleatorio(int min, int max) {
    return (int)(Math.random() * (max - min + 1)) + min;
  }
}
