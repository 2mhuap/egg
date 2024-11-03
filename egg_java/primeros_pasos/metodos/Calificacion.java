package metodos;

import java.util.Scanner;

public class Calificacion {

  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    
    System.out.print("Ingrese un número entre 0 y 100: ");
    int num = sc.nextInt();
  
    try {
      String resultado = obtenerNota(num);
      System.out.println("Calificación: " + resultado);
    } catch(IllegalArgumentException e) {
      System.out.println("El número ingresado está fuera del rango válido.");
    }

    sc.close();
  }

  public static String obtenerNota(int num) {
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
      throw new IllegalArgumentException("Calificación inválida");
    }

    return resultado;
  }
}
