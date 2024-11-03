package POO.Avanzado.AdivinandoNumero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
  static Scanner sc = new Scanner(System.in);
  static int intentos = 0;
  public static void main(String[] args) {
    int num = numeroAleatorio();
    
    boolean correcto = false;
    while(!correcto){
      correcto = pedirNumero(num);
      intentos++;
    }

    System.out.println("Adivinaste correctamente en " + intentos + " intentos.");
    sc.close();
  }
  
  private static boolean pedirNumero(int respuesta){
    try {
      System.out.print("Adivina un número entre 1 y 50: ");
      int ad = sc.nextInt();
      boolean acertado = ad == respuesta;
      if (!acertado) {
        imprimirPista(ad, respuesta);
      }
      return acertado;
    } catch (InputMismatchException e) {
      sc.nextLine();
      System.out.println("Error: valor inválido");
    }
    return false;
  }

  private static void imprimirPista(int adivinado, int respuesta){
    if (adivinado < respuesta) {
      System.out.println("El número que adivinaste es menor.");
    } else if (respuesta < adivinado) {
      System.out.println("El número que adivinaste es mayor.");
    }
  }

  private static int numeroAleatorio() {
    int min = 1;
    int max = 50;
    return (int)(Math.random() * (max - min + 1)) + min;
  }
}