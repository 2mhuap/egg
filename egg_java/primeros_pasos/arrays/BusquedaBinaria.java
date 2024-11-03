package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class BusquedaBinaria {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] a = {1,2,3,4,5};
    System.out.print("Ingrese un número para buscar: ");
    int num = sc.nextInt();
    int ind = Arrays.binarySearch(a, num);
    if (ind < 0) {
      System.out.println("No se encontró ese número.");
    } else {
      System.out.println("El indice es " + ind);
    }
    sc.close();
  }
}
