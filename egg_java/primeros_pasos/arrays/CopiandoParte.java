package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CopiandoParte {
  public static void main(String[] args) {
    int[] a = {1,2,3};
    int[] indices = {0,1,2};

    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(indices));

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese 2 indices entre 0 y 2");
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

    if (num1 < 0 || num1 > 2 || num2 < 0 || num2 > 2 ){
      System.out.println("Indice invalido");
    } else {
      int[] nuevo = Arrays.copyOfRange(a, num1, num2 + 1);
      System.out.println(Arrays.toString(nuevo));
    }

    sc.close();
  }
}
