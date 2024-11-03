package bucles;

public class ConcatenandoElementos {
  public static void main(String[] args) {
    String[] a = {"a","b","c"};

    String resultado = "";
    for (String s : a) {
      resultado += s;
    }

    System.out.println(resultado);
  }
}
