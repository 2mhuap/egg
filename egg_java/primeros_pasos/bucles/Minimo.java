package bucles;

public class Minimo {
  public static void main(String[] args) {
    int[] a = {1,2,3};

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < min){
        min = a[i];
      }
    }

    System.out.println(min);
  }
}
