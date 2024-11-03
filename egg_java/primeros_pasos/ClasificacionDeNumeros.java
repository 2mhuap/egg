import java.util.Scanner;

public class ClasificacionDeNumeros {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);
    System.out.print("Ingrese un número: ");
    int num = miScanner.nextInt();
    String resultado;
    if (num > 0) {
      resultado = "positivo";
    } else if (num < 0) {
      resultado = "negativo";
    } else {
      resultado = "cero";
    }

    System.out.println("El número es " + resultado);
    miScanner.close();
  }
}
