import java.util.Scanner;

public class LongitudCadena {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una cadena de texto: ");
    String str = miScanner.nextLine();

    System.out.println("longitud: " + str.length());

    miScanner.close();
  }
}