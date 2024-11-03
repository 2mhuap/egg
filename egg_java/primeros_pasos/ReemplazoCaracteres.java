import java.util.Scanner;

public class ReemplazoCaracteres {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una frase: ");
    String frase = miScanner.nextLine();
    System.out.print("Ingrese un carácter: ");
    String ch1 = miScanner.nextLine();
    System.out.print("Ingrese otro carácter: ");
    String ch2 = miScanner.nextLine();

    System.out.println(frase.replace(ch1, ch2));

    miScanner.close();
  }
}