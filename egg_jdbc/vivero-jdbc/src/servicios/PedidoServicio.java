package servicios;

import java.sql.Date;

import entidades.Pedido;
import persistencia.PedidoDAO;

public class PedidoServicio {
  private PedidoDAO pd;

  public PedidoServicio(){
    this.pd = new PedidoDAO();
  }

  public Pedido crearNuevoPedido(int codigoPedido, Date fechaPedido,
    Date fechaEsperada, Date fechaEntrega, String estado, String comentarios,
    int idCliente
  ) {

    // validaciones
    Pedido p = new Pedido(codigoPedido, fechaPedido, fechaEsperada, fechaEntrega,
      estado, comentarios, idCliente);
    pd.guardarPedido(p);
    return p;
  }
}
