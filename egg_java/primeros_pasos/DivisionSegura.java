import java.util.Scanner;

public class DivisionSegura {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número: ");
    int num1 = miScanner.nextInt();
    System.out.print("Ingrese otro número: ");
    int num2 = miScanner.nextInt();

    try {
      double resultado = num1 / num2;
      System.out.println("El resultado es: " + resultado);
    } catch (ArithmeticException e) {
      System.err.println("Error: No es posible dividir por 0.");
    }

    miScanner.close();
  }
}