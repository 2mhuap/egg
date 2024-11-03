package POO.Intro.Plano;

import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);
  private static int maxPuntos;
  public static void main(String[] args) {
    // Punto p = new Punto(8,11);
    // Punto q = new Punto(2,3);
    // Punto r = new Punto(-1,-2);

    Punto[] pArray = new Punto[maxPuntos];
    boolean salir = false;
    while (!salir){
      imprimirMenu();
      int op = sc.nextInt();
      // switch (op) {
      //   case 1 -> crearRectangulo(rArray);
      //   case 2 -> crearTriangulo(tArray);
      //   case 3 -> crearCirculo(cArray);
      //   case 4 -> obtenerArea(rArray, tArray, cArray);
      //   case 5 -> salir = true;
      //   default -> System.out.println("Opción inválida.");
      // }
    }

    sc.close();
    
  }

  private static void imprimirMenu() {
    System.out.println("""
      Menu:
      1. Crear punto
      2. Obtener distancia desde origen
      3. Calcula distancia entre puntos
      4. Determina si 3 puntos están alineados
      5. Salir""");
    System.out.print("Elije una opción: ");
  }
}
