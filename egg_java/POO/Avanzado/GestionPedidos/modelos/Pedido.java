package POO.Avanzado.GestionPedidos.modelos;

import java.util.ArrayList;

public class Pedido {
  private int numeroDePedido;
  private String cliente;
  private ArrayList<String> listaDeProductos = new ArrayList<String>();
  private EstadoPedido estadoDelPedido;

  public Pedido(int numeroDePedido, String cliente, ArrayList<String> listaDeProductos) {
    this.numeroDePedido = numeroDePedido;
    this.cliente = cliente;
    this.listaDeProductos = listaDeProductos;
    estadoDelPedido = EstadoPedido.PENDIENTE;
  }

  public void actualizarEstado() {
    switch (estadoDelPedido) {
      case EstadoPedido.PENDIENTE -> estadoDelPedido = EstadoPedido.ENVIADO;
      case EstadoPedido.ENVIADO -> estadoDelPedido = EstadoPedido.ENTREGADO;
      case EstadoPedido.ENTREGADO -> {}
    }
  }

  public int getNumeroDePedido() {
    return numeroDePedido;
  }

  public String getCliente() {
    return cliente;
  }

  public ArrayList<String> getListaDeProductos() {
    return listaDeProductos;
  }

  public EstadoPedido getEstadoDelPedido() {
    return estadoDelPedido;
  }

  
  

}
