package POO.Avanzado.ListaOrdenMerito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    ArrayList<Integer> notas = new ArrayList<Integer>();
    Scanner sc = new Scanner(System.in);
    boolean salir = false;
    while (!salir){
      System.out.print("Ingrese nota (número entero) o 0 para salir: ");
      int nota = sc.nextInt();
      if (nota == 0){
        salir = true;
      } else if (nota > 0 && nota <= 10) {
        notas.add(nota);
      } else {
        System.out.println("Nota inválida");
      }
    }
    
    Collections.sort(notas);
    System.out.println("Ascendente: " + notas);
    Collections.sort(notas, Collections.reverseOrder());
    System.out.println("Descendente: " + notas);
    sc.close();
  }
}
