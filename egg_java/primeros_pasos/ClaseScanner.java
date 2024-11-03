import java.util.Scanner;

public class ClaseScanner {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingresa tu nombre: ");
    String nombre = miScanner.nextLine();

    System.out.print("Ingresa tu edad: ");
    int edad = miScanner.nextInt();

    System.out.println("Tu nombre es " + nombre + " y tu edad es " + edad);
    miScanner.close();
  }
}