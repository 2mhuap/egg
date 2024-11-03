import java.util.Scanner;

public class CadenaEntero {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    try {
      System.out.print("Ingrese un número como String: ");
      String numStr = miScanner.nextLine();
      System.out.println("El resultado es: " + Integer.parseInt(numStr));
    } catch (NumberFormatException e) {
      System.err.println("Error: Se detectó un valor inválido ingresado por teclado. No se puede convertir en número.");
    } catch (Exception e) {
      System.err.println("Otro error: " + e);
    }

    miScanner.close();
  }
}