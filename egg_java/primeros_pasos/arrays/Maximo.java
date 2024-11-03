package arrays;

import java.util.Scanner;

public class Maximo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese 5 números enteros:");
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    int num3 = sc.nextInt();
    int num4 = sc.nextInt();
    int num5 = sc.nextInt();

    int[] a = {num1, num2, num3, num4, num5};
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max){
        max = a[i];
      }
    }
    System.out.println("Máximo: " + max);

    sc.close();
  }
}
