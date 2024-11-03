package Math;
import java.util.Scanner;

public class Redondeo {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número decimal: ");
    double num = miScanner.nextDouble();

    System.out.println("Redondeado: " + Math.round(num));

    miScanner.close();
  }
}