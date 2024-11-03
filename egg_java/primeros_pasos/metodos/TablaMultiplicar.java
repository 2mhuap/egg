package metodos;

import java.util.Scanner;

public class TablaMultiplicar {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int num = pedirNumero();
    imprimirTablaMultiplicar(num);
  }

  public static void imprimirTablaMultiplicar(int n) {
    for (int i = 1; i <= 10; i++) {
      int mult = n * i;
      System.out.println(n + " x " + i + " = " + mult);
    }
  }

  public static int pedirNumero() {
    System.out.print("Ingrese un número entero: ");
    return sc.nextInt();
  }

  
}
