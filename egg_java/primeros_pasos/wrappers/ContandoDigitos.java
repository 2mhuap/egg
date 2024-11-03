package wrappers;

import java.util.Scanner;

public class ContandoDigitos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese un número: ");
    Double num = sc.nextDouble();
    String str = Double.toString(num);

    int digitos = 0;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch)){
        digitos++;
      }
    }

    System.out.println("El número tiene " + digitos + " digitos.");
    sc.close();
  }
}
