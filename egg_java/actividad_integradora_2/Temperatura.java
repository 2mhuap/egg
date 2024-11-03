package actividad_integradora_2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Temperatura {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    try {
      System.out.print("Ingrese una temperatura: ");
      double temp = miScanner.nextDouble();
      miScanner.nextLine();
      System.out.print("Ingrese la unidad de medida (C/F): ");
      String unidad = miScanner.nextLine();

      if (unidad.equals("C")) {
        // unidad válida
        double f = (temp * (double)9/5) + 32;
        System.out.println(temp + " grados Celsius equivale a "
          + f + " grados Fahrenheit."
        );
      } else if (unidad.equals("F")) {
        double c = (temp - 32) * (double)5/9;
        System.out.println(temp + " grados Fahrenheit equivale a "
          + c + " grados Celsius."
        );
      } else {
        System.out.println("Error: Unidad de medida no válida. Ingrese C para Celsius o F para Fahrenheit.");
      }
    } catch(InputMismatchException e) {
      System.out.println("Error: Temperatura no válida. Ingrese una temperatura numérica.");
    }
    
    miScanner.close();
  }
}