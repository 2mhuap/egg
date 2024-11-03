package metodos;

import java.util.Scanner;

public class FactorialRecursivo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese un número: ");
    int n = sc.nextInt();
    int resultado = factorial(n);
    System.out.println("Resultado: " + resultado);
    sc.close();
  }

  public static int factorial(int num) {
    if (num == 1){
      return 1;
    }

    return num * factorial(num - 1);
  }
}
