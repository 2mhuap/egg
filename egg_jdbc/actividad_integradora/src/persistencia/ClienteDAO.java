package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Cliente;

public class ClienteDAO extends DAO<Cliente> {
  
  public Cliente getPorId(int id) {
    String sql = "SELECT id_cliente, nombre, email FROM clientes WHERE id_cliente = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      resultSet = pStatement.executeQuery();
      Cliente c = null;
      if (resultSet.next()){
        c = new Cliente();
        c.setIdCliente(resultSet.getInt("id_cliente"));
        c.setNombre(resultSet.getString("nombre"));
        c.setEmail(resultSet.getString("email"));
      }
      desconectarDataBase();
      return c;
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error getPorId cliente");
    }
    return null;
  }
  
  public ArrayList<Cliente> getTodos() {
    String sql = "SELECT id_cliente, nombre, email FROM clientes";
    try {
      consultarDataBase(sql);
      ArrayList<Cliente> todos = new ArrayList<>();
      while (resultSet.next()){
        Cliente c = new Cliente();
        c.setIdCliente(resultSet.getInt("id_cliente"));
        c.setNombre(resultSet.getString("nombre"));
        c.setEmail(resultSet.getString("email"));
        todos.add(c);
      }
      desconectarDataBase();
      return todos;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando clientes");
    }
    return null;
  }

  
  public void insertar(Cliente cliente) {
    if (cliente != null){
      String sql = "INSERT INTO clientes (nombre, calle, numero, " // 3
      + "codigo_postal, ciudad, pais, email) "
      + "VALUES " + getInterrogacion(7);
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setString(1, cliente.getNombre());
        pStatement.setString(2, cliente.getCalle());
        pStatement.setInt(3, cliente.getNumero());
        pStatement.setString(4, cliente.getCodigoPostal());
        pStatement.setString(5, cliente.getCiudad());
        pStatement.setString(6, cliente.getPais());
        pStatement.setString(7, cliente.getEmail());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error insertando cliente.");
      }
    }
  }

  
  public void update(Cliente cliente) {
    if (cliente != null){
      String sql = "UPDATE clientes SET nombre = ?, calle = ?, numero = ?, " // 3
      + "codigo_postal = ?, ciudad = ?, pais = ?, email = ? "
      + "WHERE id_cliente = ?";
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setString(1, cliente.getNombre());
        pStatement.setString(2, cliente.getCalle());
        pStatement.setInt(3, cliente.getNumero());
        pStatement.setString(4, cliente.getCodigoPostal());
        pStatement.setString(5, cliente.getCiudad());
        pStatement.setString(6, cliente.getPais());
        pStatement.setString(7, cliente.getEmail());
        pStatement.setInt(8, cliente.getIdCliente());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error update cliente.");
      }
    }
  }

  
  public void eliminarPorId(int id) {
    String sql = "DELETE FROM clientes WHERE id_cliente = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      pStatement.executeUpdate();
      desconectarDataBase();
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error eliminando cliente.");
    }
  }

  public ArrayList<Cliente> getCondicion(String condicion) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCondicion'");
  }
  
}
