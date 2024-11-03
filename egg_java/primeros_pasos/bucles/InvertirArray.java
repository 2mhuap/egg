package bucles;

import java.util.Arrays;

public class InvertirArray {
  public static void main(String[] args) {
    int[] a = {1,2,3,4,5};
    
    System.out.println(Arrays.toString(a));
    int maxIdx = a.length - 1;
    int mitad = a.length / 2;
    for (int i = 0; i < mitad; i++) {
      int temp = a[i];
      a[i] = a[maxIdx - i];
      a[maxIdx - i] = temp;
    }

    System.out.println(Arrays.toString(a));
  }
}
