import java.util.Scanner;

public class EliminacionBlanco {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una frase: ");
    String frase = miScanner.nextLine();

    System.out.println(frase.trim());

    miScanner.close();
  }
}