import java.util.Scanner;

public class DiaHabil {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número del 1 al 7: ");
    int num = miScanner.nextInt();

    String resultado = switch (num) {
      case 1, 2, 3, 4, 5 -> "Ese día es hábil.";
      case 6, 7 -> "Ese día no es hábil";
      default -> "Número inválido";
    };

    System.out.println(resultado);

    miScanner.close();
  }
}