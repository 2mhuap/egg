import java.util.Scanner;

public class CalculadoraBasica {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número: ");
    double num1 = miScanner.nextDouble();
    System.out.print("Ingrese otro número: ");
    double num2 = miScanner.nextDouble();

    System.out.print("""
        Operaciones:
        1. Suma
        2. Resta
        3. Multiplicación
        4. División
        5. Módulo
        """);
    System.out.print("Escoja una operación: ");
    int op = miScanner.nextInt();
    double resultado;
    String opString;
    switch (op) {
      case 1:
        opString = "suma";
        resultado = num1 + num2;
        break;
      case 2:
        opString = "resta";
        resultado = num1 - num2;
        break;
      case 3:
        opString = "multiplicación";
        resultado = num1 * num2;
        break;
      case 4:
        opString = "división";
        resultado = num1 / num2;
        break;
      case 5:
        opString = "módulo";
        resultado = num1 % num2;
        break;
      default:
        opString = "";
        resultado = 0;
        break;
    }
    if (opString == "") {
      System.out.println("Error - no existe esa operación.");
    } else {
      System.out.println("Operación: " + opString);
      System.out.println("El resultado es " + resultado);
    }

    miScanner.close();
  }
}
