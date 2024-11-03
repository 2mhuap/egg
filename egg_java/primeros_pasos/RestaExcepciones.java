import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaExcepciones {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    try {
      System.out.print("Ingrese un número: ");
      int num1 = miScanner.nextInt();
      System.out.print("Ingrese otro número: ");
      int num2 = miScanner.nextInt();
      double resultado = num1 - num2;
      System.out.println("El resultado es: " + resultado);
    } catch (InputMismatchException e) {
      System.err.println("Error: Se detectó un valor inválido ingresado por teclado.");
    } catch (Exception e) {
      System.err.println("Otro error: " + e);
    }

    miScanner.close();
  }
}