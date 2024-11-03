package bucles;

import java.util.Arrays;

public class Promedio {
  public static void main(String[] args) {
    float[] a = new float[20];

    for (int i = 0; i < a.length; i++) {
      a[i] = i + 1;
    }

    int suma = 0;
    for (float f : a) {
      suma += f;
    }

    System.out.println(Arrays.toString(a));
    System.out.println((float) suma / 20);
  }
}
