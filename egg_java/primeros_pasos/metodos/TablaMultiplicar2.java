package metodos;

import java.util.Scanner;

public class TablaMultiplicar2 {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int[] numeros = pedirNumeros();
    imprimirTablasMultiplicar(numeros);
    sc.close();
  }

  private static void imprimirTablasMultiplicar(int[] numeros) {
    for (int n : numeros) {
      for (int i = 1; i <= 10; i++) {
        int mult = n * i;
        System.out.println(n + " x " + i + " = " + mult);
      }
      System.out.println("----------");
    }
  }

  private static int[] pedirNumeros() {
    int[] n = new int[3];
    System.out.println("Ingrese 3 números enteros:");
    n[0] = sc.nextInt();
    n[1] = sc.nextInt();
    n[2] = sc.nextInt();
    return n;
  }

  
}
