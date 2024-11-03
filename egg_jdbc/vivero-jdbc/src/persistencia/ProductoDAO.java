package persistencia;

import java.sql.SQLException;

public class ProductoDAO extends DAO {
  public void eliminarProductoPorCodigo(int idProducto) {
    String sql = "DELETE FROM producto WHERE id_producto = " + idProducto;
    try {
      insertarModificarEliminarDataBase(sql);
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error eliminando producto.");
    }
  }
}
