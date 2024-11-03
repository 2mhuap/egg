import java.util.Scanner;

public class ConversionCalificaciones {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una calificación númerica del 1 al 5: ");
    int num = miScanner.nextInt();

    String resultado = switch (num) {
      case 1 -> "Muy deficiente";
      case 2 -> "Deficiente";
      case 3 -> "Suficiente";
      case 4 -> "Notable";
      case 5 -> "Sobresaliente";
      default -> "Número invalido";
    };

    System.out.println(resultado);

    miScanner.close();
  }
}