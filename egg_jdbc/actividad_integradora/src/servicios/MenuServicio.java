package servicios;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuServicio {
  private Scanner sc;
  private FamiliaServicio familiaServicio;
  private CasaServicio casaServicio;

  public MenuServicio(){
    this.sc = new Scanner(System.in);
    this.familiaServicio = new FamiliaServicio();
    this.casaServicio = new CasaServicio();
  }

  public void empezarMenu(){
    boolean salir = false;
    while (!salir){
      int op = opciones("""
        MENU PRINCIPAL:
        1. Casas
        2. Clientes
        3. Comentarios
        4. Estancias
        5. Familias
        6. Salir""");
      switch (op) {
        case 1 -> menuCasas();
        case 5 -> menuFamilias();
        // case 3 -> mostrarInvitados();
        case 6 -> salir = true;
        default -> System.out.println("Opción inválida");
      }
    }
  }

  private void menuCasas() {
    boolean salir = false;
    while (!salir){
      int op = opciones("""
        Casas:
        1. Listar casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido. 
        2. Listar casas disponibles a partir de una fecha, por x dias
        3. Casas por países
        4. Listar casas del Reino Unido que son 'limpias'
        5. Regresar a menu principal""");
      switch (op) {
        case 1 -> casaServicio.listarCasasCondicion("pais = 'Reino Unido' AND fecha_desde = '2020-08-01' AND fecha_hasta = '2020-08-31'");
        case 2 -> casasDisponibles();
        case 3 -> casasPaises();
        case 5 -> salir = true;
        default -> System.out.println("Opción inválida");
      }
    }
  }

  private void casasPaises() {
    System.out.println("Paises disponibles: ");
    ArrayList<String> paises = casaServicio.listarPaises();
    System.out.print("Elije pais por numero: ");
    int paisOp = sc.nextInt() - 1;
    sc.nextLine();
    if (paisOp < paises.size()){
      String paisString = paises.get(paisOp);
      casaServicio.listarCasasCondicion("pais = '" + paisString + "'");
    } else {
      System.out.println("País inválido");
    }
  }

  private void casasDisponibles() {
    System.out.print("Ingrese la fecha (AAAA-MM-DD): ");
    String fecha = sc.nextLine();
    System.out.print("Ingrese la cantidad de días: ");
    int dias = sc.nextInt();
    sc.nextLine();
    String condicion = "('" + fecha + "' BETWEEN fecha_desde AND fecha_hasta) "
    + "AND (fecha_hasta > DATE_ADD('" + fecha + "', INTERVAL "+ dias + " DAY))";
    casaServicio.listarCasasCondicion(condicion);
  }

  private void menuFamilias() {
    boolean salir = false;
    while (!salir){
      int op = opciones("""
        Familias:
        1. Listar familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años
        2. Listar familias cuya dirección de email sea Hotmail
        3. Regresar a menu principal""");
      switch (op) {
        case 1 -> familiaServicio.listarFamiliasCondicion("num_hijos >= 3 AND edad_maxima < 10");
        case 2 -> familiaServicio.listarFamiliasCondicion("email LIKE '%hotmail.com'");
        case 3 -> salir = true;
        default -> System.out.println("Opción inválida");
      }
    }
  }

  private int opciones(String menu){
    System.out.println(menu);
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }

  public void close(){
    sc.close();
  }
}
