package actividad_integradora_4;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese un número entero (posición Fibonacci): ");
    int pos = sc.nextInt();

    if (pos == 0) {
      System.out.println("[0]");
    } else if (pos == 1) {
      System.out.println("[0, 1]");
    } else {
      int length = pos + 1;
      int[] fib = new int[length];
      fib[0] = 0;
      fib[1] = 1;

      for (int i = 2; i < length; i++) {
        fib[i] = fib[i-2] + fib[i-1];
      }

      System.out.println(Arrays.toString(fib));
    }
    sc.close();
  }
}
