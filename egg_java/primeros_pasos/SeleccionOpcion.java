import java.util.Scanner;

public class SeleccionOpcion {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número del 1 al 3: ");
    int num = miScanner.nextInt();

    String resultado = switch (num) {
      case 1 -> "Guardar";
      case 2 -> "Cargar";
      case 3 -> "Salir";
      default -> "Número invalido";
    };

    System.out.println(resultado);

    miScanner.close();
  }
}