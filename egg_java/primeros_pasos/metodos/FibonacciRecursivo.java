package metodos;

import java.util.Scanner;

/**
 * FibonacciRecursivo
 */
public class FibonacciRecursivo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese la posición: ");
    int n = sc.nextInt();
    int resultado = fibonacci(n);
    System.out.println("Resultado: " + resultado);
    sc.close();
  }

  public static int fibonacci(int pos) {
    if (pos == 0){
      return 0;
    } else if (pos == 1) {
      return 1;
    }

    return fibonacci(pos - 1) + fibonacci(pos - 2);

  }
}