import java.util.Scanner;

public class Calificacion {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);
    System.out.print("Ingrese un número entre 0 y 100: ");
    int num = miScanner.nextInt();
    String resultado;
    if (num >= 90 && num <= 100) {
      resultado = "A";
    } else if (num >= 80 && num < 90) {
      resultado = "B";
    } else if (num >= 70 && num < 80) {
      resultado = "C";
    } else if (num >= 60 && num < 70) {
      resultado = "D";
    } else if (num >= 0 && num < 60) {
      resultado = "F";
    } else {
      resultado = "";
    }

    if (resultado == "") {
      System.out.println("El número ingresado está fuera del rango válido.");
    } else {
      System.out.println("Calificación: " + resultado);
    }

    miScanner.close();
  }
}
