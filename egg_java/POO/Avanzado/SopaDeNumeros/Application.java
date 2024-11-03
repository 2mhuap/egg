package POO.Avanzado.SopaDeNumeros;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    ArrayList<Integer> notas = leerValores();
    int suma = calcularSuma(notas);
    double promedio = calcularPromedio(notas);
    mostrarResultados(notas, suma, promedio);
  }

  private static ArrayList<Integer> leerValores() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> notas = new ArrayList<Integer>();
    boolean salir = false;
    while (!salir){
      System.out.print("Ingrese número entero o -99 para salir: ");
      int nota = sc.nextInt();
      if (nota == -99){
        salir = true;
      } else {
        notas.add(nota);
      }
    }
    sc.close();
    return notas;
  }

  private static void mostrarResultados(ArrayList<Integer> lista, int suma, double media){
    System.out.println("Suma: " + suma);
    System.out.println("Media aritmética: " + media);
    System.out.println("Cantidad de números superiores a la media: " + superiorMedia(lista, media));
  }

  private static int calcularSuma(ArrayList<Integer> lista){
    int suma = 0;
    for (Integer i : lista) {
      suma += i;
    }
    return suma;
  }

  private static double calcularPromedio(ArrayList<Integer> lista){
    return (double) calcularSuma(lista) / lista.size();
  }


  private static int superiorMedia(ArrayList<Integer> lista, double media){
    int numSup = 0;
    for (Integer i : lista) {
      if (i > media){
        numSup++;
      }
    }
    return numSup;
  }
}
