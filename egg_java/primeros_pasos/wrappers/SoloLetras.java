package wrappers;

import java.util.Scanner;

public class SoloLetras {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese una cadena: ");
    String str = sc.nextLine();

    boolean todosLetras = true;
    int i = 0;
    while (todosLetras && i < str.length()){
      char ch = str.charAt(i);
      if (!Character.isLetter(ch)){
        todosLetras = false;
      }
      i++;
    }

    if (todosLetras) {
      System.out.println("La cadena contiene solo letras.");
    } else {
      System.out.println("La cadena NO contiene solo letras.");
    }
    
    sc.close();
  }

}
