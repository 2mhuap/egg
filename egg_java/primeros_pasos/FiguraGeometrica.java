import java.util.Scanner;

public class FiguraGeometrica {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número del 1 al 3: ");
    int num = miScanner.nextInt();

    double resultado = switch (num) {
      case 1 -> {
        System.out.println("1. Círculo:");
        System.out.print("Ingrese el radio del círculo: ");
        double radio = miScanner.nextDouble();
        yield Math.PI * radio * radio;
      }
      case 2 -> {
        System.out.println("2. Cuadrado:");
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = miScanner.nextDouble();
        yield lado * lado;
      }
      case 3 -> {
        System.out.println("3. Triángulo:");
        System.out.print("Ingrese la base del triángulo: ");
        double base = miScanner.nextDouble();
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = miScanner.nextDouble();
        yield base * altura * 0.5;
      }
      default -> -1;
    };

    System.out.println(resultado == -1 ? "Número inválido" : resultado);
    miScanner.close();
  }
}