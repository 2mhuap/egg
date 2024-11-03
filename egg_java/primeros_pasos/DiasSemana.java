import java.util.Scanner;

public class DiasSemana {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número del 1 al 7: ");
    int num = miScanner.nextInt();

    String resultado = switch (num) {
      case 1 -> "Lunes";
      case 2 -> "Martes";
      case 3 -> "Miercoles";
      case 4 -> "Jueves";
      case 5 -> "Viernes";
      case 6 -> "Sábado";
      case 7 -> "Domingo";
      default -> "Número inválido";
    };

    System.out.println(resultado);

    miScanner.close();
  }
}