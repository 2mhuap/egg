package POO.Avanzado.ListaInvitados.servicios;

import java.util.Scanner;

import POO.Avanzado.ListaInvitados.modelos.RegistroDeInvitados;

public class MenuServicio {
  private Scanner sc;
  private RegistroDeInvitados registro;

  public MenuServicio() {
    sc = new Scanner(System.in);
    registro = new RegistroDeInvitados();
  }

  public void empezarMenu(){
    boolean salir = false;
    while (!salir){
      int op = opcionesMenu();
      switch (op) {
        case 1 -> agregarNombre();
        case 2 -> eliminarNombre();
        case 3 -> mostrarInvitados();
        case 4 -> salir = true;
        default -> System.out.println("Opción inválida");
      }
    }
  }

  private int opcionesMenu() {
    System.out.println("""
      Menu:
      1. Agregar invitado
      2. Eliminar invitado
      3. Mostrar lista actual de invitados
      4. Salir""");
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }

  private void agregarNombre(){
    System.out.print("Ingrese el nombre del invitado para agregar: ");
    String nombre = sc.nextLine();
    registro.agregarInvitado(nombre);
  }

  private void eliminarNombre(){
    registro.mostrarInvitados();
    System.out.print("Ingrese el nombre del invitado para eliminar: ");
    String nombre = sc.nextLine();
    registro.eliminarInvitado(nombre);
  }

  private void mostrarInvitados(){
    System.out.println("Mostrando invitados...");
    registro.mostrarInvitados();
  }

  public void close(){
    sc.close();
  }
}
