package wrappers;

import java.util.Scanner;

public class ContandoEspacios {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese una cadena: ");
    String str = sc.nextLine();

    int espacios = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isWhitespace(ch)){
        espacios++;
      }
    }

    System.out.println("La cadena contiene " + espacios + " espacios en blanco.");
    sc.close();
  }
}
