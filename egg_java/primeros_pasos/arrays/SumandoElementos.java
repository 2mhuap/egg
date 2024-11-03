package arrays;

public class SumandoElementos {
  public static void main(String[] args) {
    int[] a = {1,2,3};
    int suma = 0;
    for (int i = 0; i < a.length; i++) {
      suma += a[i];
    }
    System.out.println(suma);
  }
}
