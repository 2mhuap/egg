package POO.Avanzado.ListaInvitados;

import POO.Avanzado.ListaInvitados.servicios.MenuServicio;

public class Application {
  public static void main(String[] args) {
    MenuServicio menu = new MenuServicio();
    menu.empezarMenu();
    menu.close();
  }
}
