package POO.Avanzado.Turnero;

import java.util.ArrayList;
import java.util.Random;

public class Application {
  static ArrayList<Integer> numeros = new ArrayList<Integer>();
  public static void main(String[] args) {
    emitirNumeros();
    imprimirTurnos();
    atender();
    atender();
    sorteo();
    atender();
  }

  private static void atender() {
    int n = numeros.remove(0);
    System.out.println("Atendiendo número de turno: " + n);
    imprimirTurnos();
  }

  private static void atender(int indiceTurno){
    int n = numeros.remove(indiceTurno);
    System.out.println("Atendiendo número de turno: " + n);
    imprimirTurnos();
  }

  private static void imprimirTurnos() {
    System.out.println("Turnos: " + numeros.toString());
  }

  private static void sorteo() {
    Random rand = new Random();
    int randInt = rand.nextInt(numeros.size());
    System.out.print("SORTEO - ");
    atender(randInt);
  }

  private static void emitirNumeros() {
    numeros.add(8);
    numeros.add(64);
    numeros.add(9);
    numeros.add(10);
    numeros.add(65);
    numeros.add(11);
  }
}
