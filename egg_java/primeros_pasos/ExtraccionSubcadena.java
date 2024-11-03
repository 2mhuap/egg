import java.util.Scanner;

public class ExtraccionSubcadena {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una frase: ");
    String frase = miScanner.nextLine();
    System.out.print("Ingrese un número: ");
    int num1 = miScanner.nextInt();
    System.out.print("Ingrese otro número: ");
    int num2 = miScanner.nextInt();

    System.out.println(frase.substring(num1, num2));

    miScanner.close();
  }
}