package POO.Avanzado.LigaDeFutbol;

import java.util.ArrayList;
import java.util.Scanner;

import POO.Avanzado.LigaDeFutbol.modelos.Equipo;
import POO.Avanzado.LigaDeFutbol.modelos.Jugador;

public class Application {
  private static Scanner sc = new Scanner(System.in);
  private static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
  private static ArrayList<Equipo> equipos = new ArrayList<Equipo>();
  public static void main(String[] args) {
    boolean salir = false;
    while (!salir){
      int op = imprimirMenu();
      switch (op) {
        case 1 -> crearJugador();
        case 2 -> crearEquipo();
        case 3 -> asignarJugador();
        case 4 -> mostrarJugadores();
        case 5 -> mostrarEquipos();
        case 6 -> eliminarJugador();
        case 7 -> eliminarEquipo();
        case 8 -> detallesJugador();
        case 9 -> detallesEquipo();
        case 10 -> salir = true;
        case 11 -> popularEquipos();
        default -> System.out.println("Opción inválida.");
      }
    }
    sc.close();
  }

  private static void popularEquipos() {
    equipos.add(new Equipo("A"));
    equipos.add(new Equipo("B"));
    equipos.add(new Equipo("C"));
  }

  private static void detallesEquipo() {
    if (equipos.isEmpty()){
      System.out.println("No hay equipos.");
    } else {
      System.out.println("Seleccionando equipo...");
      Equipo e = seleccionarEquipo();
      
      boolean salir = false;
      while(!salir){
        int op = imprimirMenuEquipo(e.getNombre());
        switch (op) {
          case 1 -> {
            System.out.println("Detalles:");
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Cantidad de jugadores: " + e.getContadorJugadores());
          }
          case 2 -> {
            System.out.println("Cambiando nombre...");
            System.out.print("Ingrese el nombre nuevo del equipo: ");
            e.setNombre(sc.nextLine());
          }
          case 3 -> {
            if (jugadores.isEmpty()){
              System.out.println("No hay jugadores.");
            } else {
              System.out.println("Agregando jugador al equipo...");
              Jugador j = seleccionarJugador();
              j.setEquipo(e);
              System.out.println("Nuevo jugador en el equipo: " + j.getNombre());
            }
          }
          case 4 -> {
            System.out.println("Jugadores en el equipo " + e.getNombre() + ": ");
            for (Jugador j : jugadores) {
              if (j.getEquipo() == e){
                System.out.println(j.getNombre());
              }
            }
          }
          case 5 -> salir = true;
          default -> System.out.println("Opción inválida.");
        }
      }
    }
  }

  private static int imprimirMenuEquipo(String nombre) {
    System.out.println("Menu - Equipo: " + nombre);
    System.out.println("""
      1. Ver detalles
      2. Cambiar nombre
      3. Agregar jugador al equipo
      4. Mostrar jugadores del equipo
      5. Regresar al menú principal""");
    System.out.print("Elija una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }

  private static void detallesJugador() {
    if (jugadores.isEmpty()){
      System.out.println("No hay jugadores.");
    } else {
      System.out.println("Seleccionando jugador...");
      Jugador j = seleccionarJugador();
      
      boolean salir = false;
      while(!salir){
        int op = imprimirMenuJugador(j.getNombre());
        switch (op) {
          case 1 -> {
            System.out.println("Detalles:");
            System.out.println("Nombre: " + j);
          }
          case 2 -> {
            System.out.println("Cambiando nombre...");
            System.out.print("Ingrese el nombre nuevo del jugador: ");
            j.setNombre(sc.nextLine());
          }
          case 3 -> {
            if (equipos.isEmpty()){
              System.out.println("No hay equipos.");
            } else {
              System.out.println("Cambiando equipo...");
              Equipo e = seleccionarEquipo();
              j.setEquipo(e);
              System.out.println("Nuevo equipo: " + e.getNombre());
            }
          }
          case 4 -> salir = true;
          default -> System.out.println("Opción inválida.");
        }
      }
    }
  }

  private static int imprimirMenuJugador(String nombre) {
    System.out.println("Menu - Jugador: " + nombre);
    System.out.println("""
      1. Ver detalles
      2. Cambiar nombre
      3. Cambiar equipo
      4. Regresar al menú principal""");
    System.out.print("Elija una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }

  private static void eliminarEquipo() {
    if (equipos.isEmpty()){
      System.out.println("No hay equipos.");
    } else {
      System.out.println("Eliminando equipo...");
      Equipo e = seleccionarEquipo();
      System.out.println("Equipo <" + e.getNombre() + "> eliminado.");
    }
  }

  private static void eliminarJugador() {
    if (jugadores.isEmpty()){
      System.out.println("No hay jugadores.");
    } else {
      System.out.println("Eliminando jugador...");
      Jugador j = seleccionarJugador();
      jugadores.remove(j);
      System.out.println("Jugador <" + j.getNombre() + "> eliminado.");
    }
  }

  private static void asignarJugador() {
    if (jugadores.isEmpty()){
      System.out.println("No hay jugadores.");
    } else if (equipos.isEmpty()) {
      System.out.println("No hay equipos.");
    } else {
      Jugador j = seleccionarJugador();
      Equipo e = seleccionarEquipo();
      j.setEquipo(e);
      System.out.println("Asignado: " + j.getNombre() + " -> " + e.getNombre());
    }
  }

  private static Jugador seleccionarJugador() {
    System.out.println("Jugadores:");
    for (int i = 0; i < jugadores.size(); i++) {
      Jugador j = jugadores.get(i);
      System.out.println((i + 1) + ". " + j.getNombre());
    }
    System.out.print("Escoja un jugador: ");
    int jugOp = sc.nextInt();
    sc.nextLine();
    return jugadores.get(jugOp - 1);
  }

  private static Equipo seleccionarEquipo() {
    System.out.println("Equipos:");
    for (int i = 0; i < equipos.size(); i++) {
      Equipo e = equipos.get(i);
      System.out.println((i + 1) + ". " + e.getNombre());
    }
    System.out.print("Escoja un equipo: ");
    int eqOp = sc.nextInt();
    sc.nextLine();
    return equipos.get(eqOp - 1);
  }

  private static void crearEquipo() {
    System.out.println("Creando equipo...");
    System.out.print("Ingrese el nombre del equipo: ");
    String nombre = sc.nextLine();
    Equipo e = new Equipo(nombre);
    System.out.println("Equipo creado.");
    equipos.add(e);
  }

  private static void mostrarJugadores() {
    if (jugadores.isEmpty()){
      System.out.println("No hay jugadores.");
    } else {
      System.out.println("-Jugadores---------");
      for (Jugador j : jugadores) {
        System.out.println("- " + j);
      }
      System.out.println("-------------------");
    }
  }

  private static void mostrarEquipos() {
    if (equipos.isEmpty()){
      System.out.println("No hay equipos.");
    } else {
      System.out.println("-Equipos----------");
      for (Equipo e : equipos) {
        System.out.println("  " + e.getNombre());
      }
      System.out.println("------------------");
    }
  }

  private static void crearJugador() {
    System.out.println("Creando jugador...");
    System.out.print("Ingrese el nombre del jugador: ");
    String nombre = sc.nextLine();
    Jugador j = new Jugador(nombre);
    System.out.println("Jugador creado.");
    if (equipos.isEmpty()) {
      System.out.println("No hay equipos disponibles.");
    } else {
      Equipo e = seleccionarEquipo();
      j.setEquipo(e);
    } 
    jugadores.add(j);
  }

  private static int imprimirMenu() {
    System.out.println("""
      Menu:
      1. Crear jugador
      2. Crear equipo
      3. Asignar jugador a equipo
      4. Mostrar lista de jugadores
      5. Mostrar lista de equipos
      6. Eliminar jugador
      7. Eliminar equipo
      8. Seleccionar jugador
      9. Seleccionar equipo
      10. Salir""");
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }
}
