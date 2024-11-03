package Math;
import java.util.Scanner;

public class RaizCuadrada {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número positivo: ");
    double num = miScanner.nextDouble();

    System.out.println("Raíz cuadrada: " + Math.sqrt(num));

    miScanner.close();
  }
}