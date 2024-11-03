package POO.Intro.FigurasGeometricas;

// import java.util.Arrays;
import java.util.Scanner;
import POO.Intro.FigurasGeometricas.modelos.*;

public class Main {
  static Scanner sc = new Scanner(System.in);
  static int maxFiguras = 5;
  public static void main(String[] args) {
    Rectangulo[] rArray = new Rectangulo[maxFiguras];
    Triangulo[] tArray = new Triangulo[maxFiguras];
    Circulo[] cArray = new Circulo[maxFiguras];

    boolean salir = false;
    while (!salir){
      imprimirMenu();
      int op = sc.nextInt();
      switch (op) {
        case 1 -> crearRectangulo(rArray);
        case 2 -> crearTriangulo(tArray);
        case 3 -> crearCirculo(cArray);
        case 4 -> obtenerArea(rArray, tArray, cArray);
        case 5 -> obtenerPerimetro(rArray, tArray, cArray);
        case 6 -> obtenerTotal();
        case 7 -> salir = true;
        default -> System.out.println("Opción inválida.");
      }
    }
    // System.out.println(Arrays.toString(rArray));

    sc.close();
  }

  private static void imprimirMenu() {
    System.out.println("""
      Menu:
      1. Crear rectangulo
      2. Crear triangulo
      3. Crear circulo
      4. Obtener área
      5. Obtener perímetro
      6. Obtener número total de rectangulos
      7. Salir""");
    System.out.print("Elije una opción: ");
  }

  private static void crearRectangulo(Rectangulo[] rs) {
    if (Rectangulo.contadorRectangulos < maxFiguras){
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

  private static void crearTriangulo(Triangulo[] ts) {
    if (Triangulo.contadorTriangulos < maxFiguras){
      System.out.println("Creando un triangulo:");
      Triangulo t = new Triangulo();
      System.out.print("Ingrese el ancho: ");
      int ancho = sc.nextInt();
      t.setAncho(ancho);
      System.out.print("Ingrese el alto: ");
      int alto = sc.nextInt();
      t.setAlto(alto);
      ts[Triangulo.contadorTriangulos - 1] = t;
      System.out.println("Triangulo creado.");
    } else {
      System.out.println("No hay espacio para crear más triangulos.");
    }
  }

  private static void crearCirculo(Circulo[] cs) {
    if (Circulo.contadorCirculos < maxFiguras){
      System.out.println("Creando un circulo:");
      Circulo c = new Circulo();
      System.out.print("Ingrese el radio: ");
      int radio = sc.nextInt();
      c.setRadio(radio);
      cs[Circulo.contadorCirculos - 1] = c;
      System.out.println("Circulo creado.");
    } else {
      System.out.println("No hay espacio para crear más circulos.");
    }
  }

  private static void obtenerArea(Rectangulo[] rs, Triangulo[] ts, Circulo[] cs) {
    System.out.println("""
      Escoje una figura geométrica:
      1. Rectangulo
      2. Triangulo
      3. Circulo""");
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    switch (op) {
      case 1 -> obtenerAreaRectangulo(rs);
      case 2 -> obtenerAreaTriangulo(ts);
      case 3 -> obtenerAreaCirculo(cs);
      default -> System.out.println("Opción inválida.");
    }
  }

  private static void obtenerAreaRectangulo(Rectangulo[] rs){
    if (Rectangulo.contadorRectangulos > 0) {
      int i = escojerIndice("rectangulos", Rectangulo.contadorRectangulos);
      if (i < Rectangulo.contadorRectangulos){
        rs[i].imprimirArea();
      } else {
        System.out.println("Número inválido.");
      }
    } else {
      System.out.println("No hay rectangulos.");
    }
  }

  private static void obtenerAreaTriangulo(Triangulo[] ts){
    if (Triangulo.contadorTriangulos > 0) {
      int i = escojerIndice("triangulos", Triangulo.contadorTriangulos);
      if (i < Triangulo.contadorTriangulos){
        ts[i].imprimirArea();
      } else {
        System.out.println("Número inválido.");
      }
    } else {
      System.out.println("No hay triangulos.");
    }
  }

  private static void obtenerAreaCirculo(Circulo[] cs){
    if (Circulo.contadorCirculos > 0) {
      int i = escojerIndice("circulos", Circulo.contadorCirculos);
      if (i < Circulo.contadorCirculos){
        cs[i].imprimirArea();
      } else {
        System.out.println("Número inválido.");
      }
    } else {
      System.out.println("No hay circulos.");
    }
  }

  private static void obtenerPerimetro(Rectangulo[] rs, Triangulo[] ts, Circulo[] cs) {
    System.out.println("""
      Escoje una figura geométrica:
      1. Rectangulo
      2. Circulo""");
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    switch (op) {
      case 1 -> obtenerPerimetroRectangulo(rs);
      case 2 -> obtenerPerimetroCirculo(cs);
      default -> System.out.println("Opción inválida.");
    }
  }

  private static void obtenerPerimetroRectangulo(Rectangulo[] rs) {
    if (Rectangulo.contadorRectangulos > 0) {
      int i = escojerIndice("rectangulos", Rectangulo.contadorRectangulos);
      if (i < Rectangulo.contadorRectangulos){
        rs[i].imprimirPerimetro();
      } else {
        System.out.println("Número inválido.");
      }
    } else {
      System.out.println("No hay rectangulos.");
    }
  }

  private static void obtenerPerimetroCirculo(Circulo[] cs) {
    if (Circulo.contadorCirculos > 0) {
      int i = escojerIndice("circulos", Circulo.contadorCirculos);
      if (i < Circulo.contadorCirculos){
        cs[i].imprimirPerimetro();
      } else {
        System.out.println("Número inválido.");
      }
    } else {
      System.out.println("No hay circulos.");
    }
  }

  private static int escojerIndice(String figura, int contador){
    String mensaje = "Actualmente, hay %d %s. Del 1 al %d (inclusivo), de cual quiere el perímetro?";
    mensaje = String.format(mensaje, contador, figura, contador);
    System.out.println(mensaje);
    int i = sc.nextInt();
    return i - 1;
  }

  private static void obtenerTotal() {
    System.out.println("Número total de rectangulos: " + Rectangulo.contadorRectangulos);
  }

  
}
