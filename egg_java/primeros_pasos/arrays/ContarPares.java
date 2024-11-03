package arrays;

public class ContarPares {
  public static void main(String[] args) {
    int[] a = {1,2,2,4,5,6};
    int pares = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] % 2 == 0){
        pares++;
      }
    }
    System.out.println(pares);
  }
}
