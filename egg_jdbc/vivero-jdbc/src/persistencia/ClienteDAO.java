package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Cliente;

public class ClienteDAO extends DAO {
  public void guardarCliente(Cliente cliente) {
    if (cliente != null){
      String sql = "INSERT INTO cliente VALUES (";
      sql += cliente.getIdCliente() + ", ";
      sql += cliente.getCodigoCliente() + ", ";
      sql += cliente.getNombreCliente() + ", ";
      sql += cliente.getNombreContacto() + ", ";
      sql += cliente.getApellidoContacto() + ", ";
      sql += cliente.getTelefono() + ", ";
      sql += cliente.getFax() + ", ";
      sql += cliente.getCiudad() + ", ";
      sql += cliente.getRegion() + ", ";
      sql += cliente.getPais() + ", ";
      sql += cliente.getCodigoPostal() + ", ";
      sql += cliente.getIdEmpleado() + ", ";
      sql += cliente.getLimiteCredito() + ")";

      try {
        insertarModificarEliminarDataBase(sql);
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error guardando cliente.");
      }
    }
  }

  public void listarTodosLosClientes() {
    String sql = "SELECT id_cliente, nombre_contacto, apellido_contacto FROM cliente";
    try {
      consultarDataBase(sql);
      ArrayList<Cliente> todos = new ArrayList<Cliente>();
      while (resultSet.next()){
        Cliente c = new Cliente();
        c.setIdCliente(resultSet.getInt("id_cliente"));
        c.setNombreContacto(resultSet.getString("nombre_contacto"));
        c.setApellidoContacto(resultSet.getString("apellido_contacto"));
        todos.add(c);
      }
      desconectarDataBase();
      System.out.println("CLIENTES:");
      for (Cliente c : todos) {
        System.out.println(c.getIdCliente() + " - " + c.getNombreContacto() + " - " + c.getApellidoContacto());
      }
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando clientes");
      System.out.println(e.getMessage());
    }
  }

  public Cliente buscarClientePorCodigo(int idCliente) {
    String sql = "SELECT * FROM cliente WHERE id_cliente = " + idCliente;
    try {
      consultarDataBase(sql);
      Cliente c = new Cliente();
      while (resultSet.next()){
        c.setIdCliente(resultSet.getInt("id_cliente"));
        c.setNombreCliente(resultSet.getString("nombre_cliente"));
        c.setNombreContacto(resultSet.getString("nombre_contacto"));
        c.setApellidoContacto(resultSet.getString("apellido_contacto"));
      }
      desconectarDataBase();
      return c;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando clientes");
      System.out.println(e.getMessage());
    } 

    return null;
  }
}
