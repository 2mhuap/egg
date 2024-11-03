package actividad_integradora_3;

import java.util.Arrays;

public class Fibonacci {
  public static void main(String[] args) {
    int length = 8;

    int[] fib = new int[length];
    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i < length; i++) {
      fib[i] = fib[i-2] + fib[i-1];
    }

    System.out.println(Arrays.toString(fib));

  }
}
