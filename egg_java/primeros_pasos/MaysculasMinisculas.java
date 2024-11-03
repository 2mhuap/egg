import java.util.Scanner;

public class MaysculasMinisculas {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una cadena de texto: ");
    String str1 = miScanner.nextLine();

    System.out.println("Mayúsculas: " + str1.toUpperCase());
    System.out.println("Minúsculas: " + str1.toLowerCase());


    miScanner.close();
  }
}