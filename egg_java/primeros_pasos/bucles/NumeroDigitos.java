package bucles;

import java.util.Scanner;

/**
 * MenuInteractivo
 */
public class NumeroDigitos {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese un número: ");
    String num = sc.nextLine();

    String digitos = num.replace("-","");

    int cantidad = 0;
    int i = 0;
    while(i != digitos.length()){
     cantidad++;
     i++;
    }
    System.out.println("Número de digitos: " + cantidad);
    sc.close();
  }
}