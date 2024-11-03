package Math;
import java.util.Scanner;

public class ValorAbsoluto {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número entero: ");
    int num = miScanner.nextInt();

    System.out.println("Valor absoluto: " + Math.abs(num));

    miScanner.close();
  }
}