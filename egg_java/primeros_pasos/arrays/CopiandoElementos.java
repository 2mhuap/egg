package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CopiandoElementos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] a = {1,2,3};
    int[] nuevo = new int[a.length + 2];
    nuevo[0] = a[0];
    nuevo[1] = a[1];
    nuevo[2] = a[2];

    System.out.println("Ingrese 2 números enteros:");
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

    nuevo[3] = num1;
    nuevo[4] = num2;

    System.out.println("Nuevo array: " + Arrays.toString(nuevo));

    sc.close();
  }
}
