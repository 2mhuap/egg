package servicios;

import java.util.Scanner;

public class MenuServicio {
  private Scanner sc;
  private ClienteServicio cs;
  private PedidoServicio ps;

  public MenuServicio() {
    this.sc = new Scanner(System.in);
    this.cs = new ClienteServicio();
    this.ps = new PedidoServicio();
  }

  public void empezarMenu(){
    boolean salir = false;
    while (!salir){
      int op = opcionesMenu();
      switch (op) {
        case 1 -> agregarCliente();
        case 2 -> mostrarClientes();
        // case 3 -> mostrarInvitados();
        case 4 -> salir = true;
        default -> System.out.println("Opción inválida");
      }
    }
  }

  private void mostrarClientes() {
    try {
      cs.listarClientes();
    } catch (Exception e) {
      System.out.println("Error cliente servicio");
    }
  }

  private String cadenasSQL(String str){
    return "'" + str + "'";
  }

  private void agregarCliente() {
    System.out.println("AGREGAR CLIENTE");
    System.out.print("Ingrese el codigo del cliente: ");
    int codigoCliente = sc.nextInt();
    sc.nextLine();
    System.out.print("Ingrese el nombre del cliente: ");
    String nombreCliente = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese el nombre del contacto: ");
    String nombreContacto = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese el apellido del contacto: ");
    String apellidoContacto = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese el telefono: ");
    String telefono = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese el fax: ");
    String fax = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese la ciudad: ");
    String ciudad = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese la region: ");
    String region = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese el pais: ");
    String pais = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese el codigo postal: ");
    String codigoPostal = cadenasSQL(sc.nextLine());
    System.out.print("Ingrese el id del empleado: ");
    int idEmpleado = sc.nextInt();
    sc.nextLine();
    System.out.print("Ingrese el limite de credito: ");
    double limiteCredito = sc.nextDouble();
    sc.nextLine();

    try {
      cs.crearNuevoCliente(codigoCliente,
        nombreCliente,
        nombreContacto,
        apellidoContacto,
        telefono,
        fax,
        ciudad,
        region,
        pais,
        codigoPostal,
        idEmpleado,
        limiteCredito);
    } catch (Exception e) {
      System.out.println("Error agregando cliente");
    }
  }

  private int opcionesMenu() {
    System.out.println("""
      Menu:
      1. Agregar cliente
      2. Mostrar lista de clientes
      3. Agregar pedido
      4. Salir""");
    System.out.print("Elije una opción: ");
    int op = sc.nextInt();
    sc.nextLine();
    return op;
  }

  public void close(){
    sc.close();
  }
}
