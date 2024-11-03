package arrays;

import java.util.Arrays;

public class Comparando {
  public static void main(String[] args) {
    int[] a = {1,2,3};
    int[] b = {2,3,1};
    int[] c = {1,2,3};

    System.out.println(Arrays.equals(a, b));
    System.out.println(Arrays.equals(a, c));
  }
}
