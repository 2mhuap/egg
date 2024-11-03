package wrappers;

import java.util.Scanner;

public class SumaNumeros {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese una cadena (número entero): ");
    String intString = sc.nextLine();
    System.out.print("Ingrese una cadena (número decimal): ");
    String doubleString = sc.nextLine();

    try {
      int i = Integer.valueOf(intString);
      double d = Double.valueOf(doubleString);
      System.out.println("La suma de los números es " + (i + d));
    } catch (NumberFormatException e) {
      System.out.println("NumberFormatException: La entrada no es un número valido.");
    }
    
    sc.close();
  }

}
