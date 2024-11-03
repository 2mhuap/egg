package bucles;

import java.util.Scanner;

/**
 * MenuInteractivo
 */
public class MenuInteractivo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean salir = false;
    String mensaje = """
        1. Comprar producto.
        2. Realizar devolución.
        3. Ver mis pedidos.
        4. Preguntas frecuentes.
        5. Salir.
        Escoja una opción:""";
    while(!salir){
      System.out.println(mensaje);
      int op = sc.nextInt();
      switch (op) {
        case 1:
          System.out.println("Comprar producto");
          break;
        case 2:
          System.out.println("Realizar devolución");
          break;
        case 3:
          System.out.println("Ver mis pedidos");
          break;
        case 4:
          System.out.println("Preguntas frecuentes");
          break;
        case 5:
          System.out.println("Saliendo");
          salir = true;
          break;
        default:
          System.out.println("Opción invalida.");
          break;
      }
    }
    sc.close();
  }
}