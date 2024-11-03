import java.util.Scanner;

public class ConcatCadenas {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese su nombre: ");
    String str1 = miScanner.nextLine();
    System.out.print("y apellido: ");
    String str2 = miScanner.nextLine();

    System.out.println(str1.concat(" ".concat(str2)));

    miScanner.close();
  }
}