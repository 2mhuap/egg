package Math;
import java.util.Scanner;

public class Potencia {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número entero: ");
    int num1 = miScanner.nextInt();
    System.out.print("Ingrese otro número entero: ");
    int num2 = miScanner.nextInt();

    System.out.println(num1 + "^" + num2 + ": " + Math.pow(num1, num2));

    miScanner.close();
  }
}