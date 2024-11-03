import java.util.Scanner;

public class IdentificadorNumero {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número: ");
    int num = miScanner.nextInt();

    System.out.println((num % 2 == 0) ? "El número es par." : "El número es impar.");
    miScanner.close();

  }
}
