package POO.Avanzado.GestionCatalogoLibreria;

import java.util.Scanner;

import POO.Avanzado.GestionCatalogoLibreria.modelos.Libreria;
import POO.Avanzado.GestionCatalogoLibreria.modelos.Libro;

public class Application {
  private static Scanner sc = new Scanner(System.in);
  private static Libreria libreria = new Libreria();

  public static void main(String[] args) {
    boolean salir = false;
    while (!salir){
      int op = opcionesMenu();
      switch (op) {
        case 1 -> agregarLibro();
        case 2 -> eliminarLibro();
        case 3 -> mostrarCatalogo();
        case 4 -> salir = true;
        default -> System.out.println("Opción inválida");
      }
    }
    sc.close();
  }

  private static int opcionesMenu() {
    System.out.println("""
      Menu:
      1. Agregar libro
      2. Eliminar libro
      3. Mostrar catálogo actual de la librería
      4. Salir""");
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }

  private static void agregarLibro(){
    System.out.println("Agregar libro:");
    System.out.print("Ingrese el titulo del libro: ");
    String titulo = sc.nextLine();
    System.out.print("Ingrese el autor del libro: ");
    String autor = sc.nextLine();
    System.out.print("Ingrese el ISBN del libro: ");
    String isbn = sc.nextLine();
    Libro l = new Libro(titulo, autor, isbn);
    libreria.agregarLibro(l);
  }

  private static void eliminarLibro(){
    System.out.println("Eliminar libro:");
    libreria.mostrarCatalogo();
    System.out.print("Ingrese el ISBN del libro para eliminar: ");
    String isbn = sc.nextLine();
    libreria.eliminarLibro(isbn);
  }

  private static void mostrarCatalogo(){
    System.out.println("Mostrando catálogo...");
    libreria.mostrarCatalogo();
  }
}
