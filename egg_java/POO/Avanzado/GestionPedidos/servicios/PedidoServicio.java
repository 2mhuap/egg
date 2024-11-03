package POO.Avanzado.GestionPedidos.servicios;

import java.util.ArrayList;
import java.util.Scanner;

import POO.Avanzado.GestionPedidos.modelos.Pedido;
import POO.Avanzado.GestionPedidos.modelos.EstadoPedido;

public class PedidoServicio {
  // crear un nuevo pedido
  // actualizar el estado de un pedido existente
  // buscar pedidos por estado
  // obtener la lista completa de pedidos
  // permitiendo también realizar filtros sobre la misma

  // Scanner sc = new Scanner(System.in);
  // sc.close();
  private int contadorPedidos = 0;
  private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

  public Pedido crearPedido() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Creando pedido...");
    System.out.print("Ingrese el nombre del cliente: ");
    String cliente = sc.nextLine();
    System.out.print("Ingrese producto para agregar a la lista (o '0' para terminar la lista): ");
    ArrayList<String> prods = new ArrayList<String>();
    String producto = sc.nextLine();
    while (!producto.equals("0")){
      prods.add(producto);
      producto = sc.nextLine();
    }
    System.out.println("Lista de productos terminada.");
    sc.close();
    Pedido p = new Pedido(contadorPedidos, cliente, prods);
    pedidos.add(p);
    contadorPedidos++;
    return p;
  }

  public Pedido seleccionarPedido(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Seleccion de pedidos:");
    for (int i = 0; i < pedidos.size(); i++) {
      Pedido p = pedidos.get(i);
      System.out.println((i + 1) + " - " + p.getCliente() + ": " + p.getListaDeProductos().toString());
    }
    System.out.print("Elija un pedido: ");
    int op = sc.nextInt();
    sc.nextLine();
    sc.close();
    return pedidos.get(op - 1);
  }

  public void actualizarEstado(){
    Pedido p = seleccionarPedido();
    p.actualizarEstado();
    System.out.println("Pedido: " + p.getCliente());
    System.out.println("Estado actualizado: " + p.getEstadoDelPedido());
  }

  public void mostrarPedidosPorEstado(){
    EstadoPedido estado = seleccionarEstado();
  }

  public EstadoPedido seleccionarEstado(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Seleccion de estado:");
    EstadoPedido[] estados = EstadoPedido.values();
    for (int i = 0; i < estados.length; i++) {
      EstadoPedido e = estados[i];
      System.out.println((i + 1) + " - " + e);
    }
    System.out.print("Elija un estado: ");
    int op = sc.nextInt();
    sc.nextLine();
    sc.close();
    return estados[op - 1];
  }
}
