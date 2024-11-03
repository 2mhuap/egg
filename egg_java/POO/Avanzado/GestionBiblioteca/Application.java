package POO.Avanzado.GestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import POO.Avanzado.GestionBiblioteca.modelos.Biblioteca;
import POO.Avanzado.GestionBiblioteca.modelos.Libro;
import POO.Avanzado.GestionBiblioteca.modelos.Persona;

public class Application {
  public static Biblioteca bib = new Biblioteca();
  public static Scanner sc = new Scanner(System.in);
  public static ArrayList<Persona> usuarios = new ArrayList<Persona>();
  public static void main(String[] args) {
    Libro l1 = new Libro("A", "autorA", 220, 2.5);
    Libro l2 = new Libro("B", "autorB", 320, 2.5);
    Libro l3 = new Libro("C", "autorC", 380, 2.5);
    bib.agregarLibro(l1);
    bib.agregarLibro(l2);
    bib.agregarLibro(l3);

    Persona p1 = new Persona("Persona A", "ApellidoA");
    Persona p2 = new Persona("Persona B", "ApellidoB");
    usuarios.add(p1);
    usuarios.add(p2);

    boolean salir = false;
    while(!salir){
      int op = imprimirMenu();
      switch (op) {
        case 1 -> bib.mostrarLibros();
        case 2 -> agregarLibro();
        case 3 -> mostrarDetallesLibro();
        case 4 -> prestarLibro();
        case 5 -> devolverLibro();
        case 6 -> salir = true;
        default -> System.out.println("Opción inválida.");
      }
    }

    sc.close();
  }

  private static void devolverLibro() {
    Persona p = seleccionarUsuario();
    Libro l = seleccionarLibro();
    p.devolverLibro(l);
  }

  private static void prestarLibro() {
    Persona p = seleccionarUsuario();
    Libro l = seleccionarLibro();
    p.prestarLibro(l);
  }

  private static Persona seleccionarUsuario() {
    System.out.println("Seleccionando usuario...");
    for (int i = 0; i < usuarios.size(); i++) {
      System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
    }
    int usuarioI = sc.nextInt();
    sc.nextLine();
    return usuarios.get(usuarioI - 1);
  }

  private static void mostrarDetallesLibro() {
    Libro l = seleccionarLibro();
    System.out.println("Mostrando detalles...");
    l.obtenerInformacion();
  }

  private static Libro seleccionarLibro() {
    System.out.println("Seleccionando libro...");
    for (int i = 0; i < bib.getLibros().size(); i++) {
      Libro l = bib.getLibros().get(i);
      System.out.println((i + 1) + ". " + l.getTitulo());
    }
    int libroI = sc.nextInt();
    sc.nextLine();
    return bib.getLibros().get(libroI - 1);
  }

  private static void agregarLibro() {
    System.out.println("Agregando libro...");
    System.out.print("Ingrese titulo del libro: ");
    String titulo = sc.nextLine();
    Libro l = new Libro(titulo, "autor", 100, 5);
    bib.agregarLibro(l);
    System.out.println("Libro agregado.");
  }

  private static int imprimirMenu() {
    System.out.println("""
      Menu:
      1. Mostrar libros en biblioteca
      2. Agregar libro a biblioteca
      3. Mostrar detalles de un libro
      4. Prestar libro
      5. Devolver libro
      6. Salir""");
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }


}
