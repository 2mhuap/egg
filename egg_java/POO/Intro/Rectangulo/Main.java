package POO.Intro.Rectangulo;

// import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);
  static int maxRectangulos = 5;
  public static void main(String[] args) {
    Rectangulo[] rArray = new Rectangulo[maxRectangulos];

    boolean salir = false;
    while (!salir){
      imprimirMenu();
      int op = sc.nextInt();
      switch (op) {
        case 1 -> crearRectangulo(rArray);
        case 2 -> obtenerArea(rArray);
        case 3 -> obtenerPerimetro(rArray);
        case 4 -> obtenerTotal();
        case 5 -> salir = true;
        default -> System.out.println("Opción inválida.");
      }
    }
    // System.out.println(Arrays.toString(rArray));

    sc.close();
  }

  private static void obtenerTotal() {
    System.out.println("Número total de rectangulos: " + Rectangulo.contadorRectangulos);
  }

  private static void imprimirMenu() {
    System.out.println("""
        Menu:
        1. Crear rectangulo
        2. Obtener área de un rectangulo
        3. Obtener perímetro de un rectangulo
        4. Obtener número total de rectangulos
        5. Salir""");
    System.out.print("Elije una opción: ");
  }

  private static void crearRectangulo(Rectangulo[] rs) {
    if (Rectangulo.contadorRectangulos < maxRectangulos){
      System.out.println("Creando un rectangulo:");
      System.out.print("Ingrese el ancho: ");
      int ancho = sc.nextInt();
      System.out.print("Ingrese el alto: ");
      int alto = sc.nextInt();
      Rectangulo r = new Rectangulo(ancho, alto);
      rs[Rectangulo.contadorRectangulos - 1] = r;
      System.out.println("Rectangulo creado.");
    } else {
      System.out.println("No hay espacio para crear más rectangulos.");
    }
  }

  private static void obtenerArea(Rectangulo[] rs) {
    if (Rectangulo.contadorRectangulos > 0) {
      String mensaje = "Actualmente, hay %d rectangulos. Del 1 al %d (inclusivo), de cual quiere el área?";
      mensaje = String.format(mensaje, Rectangulo.contadorRectangulos, Rectangulo.contadorRectangulos);
      System.out.println(mensaje);
      int i = sc.nextInt() - 1;
      if (i < Rectangulo.contadorRectangulos){
        rs[i].imprimirArea();
      } else {
        System.out.println("Número inválido.");
      }
    } else {
      System.out.println("No hay rectangulos.");
    }
  }

  private static void obtenerPerimetro(Rectangulo[] rs) {
    if (Rectangulo.contadorRectangulos > 0) {
      String mensaje = "Actualmente, hay %d rectangulos. Del 1 al %d (inclusivo), de cual quiere el perímetro?";
      mensaje = String.format(mensaje, Rectangulo.contadorRectangulos, Rectangulo.contadorRectangulos);
      System.out.println(mensaje);
      int i = sc.nextInt() - 1;
      if (i < Rectangulo.contadorRectangulos){
        rs[i].imprimirPerimetro();
      } else {
        System.out.println("Número inválido.");
      }
    } else {
      System.out.println("No hay rectangulos.");
    }
  }

  
}
