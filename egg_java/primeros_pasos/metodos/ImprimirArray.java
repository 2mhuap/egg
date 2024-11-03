package metodos;

public class ImprimirArray {
  public static void main(String[] args) {
    int[] aInt = {1,2,3};
    String[] aString = {"a", "b", "c"};

    imprimirArray(aInt);
    imprimirArray(aString);
  }

  public static void imprimirArray(int[] a) {
    System.out.println("Imprimiendo array de int:");
    for (int i : a) {
      System.out.println(i);
    }
  }

  public static void imprimirArray(String[] a) {
    System.out.println("Imprimiendo array de String:");
    for (String s : a) {
      System.out.println(s);
    }
  }
}
