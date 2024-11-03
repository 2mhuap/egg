package bucles;

import java.util.Scanner;

/**
 * MenuInteractivo
 */
public class AdivinandoNumero {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int min = 1;
    int max = 20;
    int num = (int)(Math.random() * (max - min + 1)) + min; 
    boolean correcto = false;

    while(!correcto){
      System.out.print("Adivina un número entre 1 y 20: ");
      int ad = sc.nextInt();
      if (ad == num){
        correcto = true;
      } else if (ad < num) {
        System.out.println("El número que adivinaste es menor.");
      } else {
        System.out.println("El número que adivinaste es mayor.");
      }
    }

    System.out.println("Adivinaste correctamente!");
    sc.close();
  }
}