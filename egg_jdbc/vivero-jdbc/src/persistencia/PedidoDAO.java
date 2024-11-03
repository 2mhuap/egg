package persistencia;

import java.sql.SQLException;

import entidades.Pedido;

public class PedidoDAO extends DAO {
  public void guardarPedido(Pedido pedido) {
    if (pedido != null){
      String sql = "INSERT INTO pedido (codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, id_cliente) VALUES (" +
      pedido.getCodigoPedido() + ", " +
      "'" + pedido.getFechaPedido() + "', " +
      "'" + pedido.getFechaEsperada() + "', " +
      "'" + pedido.getFechaEntrega() + "', " +
      pedido.getEstado() + ", " +
      pedido.getComentarios() + ", " +
      pedido.getIdCliente() + ")";
      try {
        insertarModificarEliminarDataBase(sql);
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error guardando pedido.");
      }
    }
  }
}
