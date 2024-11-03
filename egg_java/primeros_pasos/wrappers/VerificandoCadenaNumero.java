package wrappers;

import java.util.Scanner;

public class VerificandoCadenaNumero {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese una cadena: ");
    String str = sc.nextLine();
    try {
      double num = Double.valueOf(str);
      System.out.println("La entrada es número válido.");
    } catch (NumberFormatException e) {
      System.out.println("NumberFormatException: La entrada no es un número valido.");
    }
    
    sc.close();
  }

}
