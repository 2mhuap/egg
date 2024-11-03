package arrays;

import java.util.Arrays;

/**
 * OrdenarDescendente
 */
public class OrdenarDescendente {

  public static void main(String[] args) {
    int[] a = new int[10];
    int min = 1;
    int max = 100;

    for (int i = 0; i < a.length; i++) {
      a[i] = (int)(Math.random() * (max - min + 1)) + min;
    }

    Arrays.sort(a);
    System.out.println(Arrays.toString(a));
  }
}