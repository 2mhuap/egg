package bucles;

import java.util.Arrays;

public class ContandoPares {
  public static void main(String[] args) {
    int[] a = new int[10];

    for (int i = 0; i < a.length; i++) {
      int num = (int) (Math.random() * 100);
      a[i] = num;
    }

    int pares = 0;
    for (int num : a) {
      if (num % 2 == 0){
        pares++;
      }
    }

    System.out.println(Arrays.toString(a));
    System.out.println("Pares: " + pares);
  }
}
