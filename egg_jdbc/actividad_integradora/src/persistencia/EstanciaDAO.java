package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Estancia;

public class EstanciaDAO extends DAO<Estancia> {

  public Estancia getPorId(int id) {
    String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped FROM estancias WHERE id_estancia = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      resultSet = pStatement.executeQuery();
      Estancia e = null;
      if (resultSet.next()){
        e = new Estancia();
        e.setIdEstancia(resultSet.getInt("id_estancia"));
        e.setIdCliente(resultSet.getInt("id_cliente"));
        e.setIdCasa(resultSet.getInt("id_casa"));
        e.setNombreHuesped(resultSet.getString("nombre_huesped"));
      }
      desconectarDataBase();
      return e;
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error getPorId estancia");
    }
    return null;
  }

  public ArrayList<Estancia> getTodos() {
    String sql = "SELECT id_estancia, id_cliente, id_casa, nombre_huesped FROM estancias";
    try {
      consultarDataBase(sql);
      ArrayList<Estancia> todos = new ArrayList<>();
      while (resultSet.next()){
        Estancia e = new Estancia();
        e.setIdEstancia(resultSet.getInt("id_estancia"));
        e.setIdCliente(resultSet.getInt("id_cliente"));
        e.setIdCasa(resultSet.getInt("id_casa"));
        e.setNombreHuesped(resultSet.getString("nombre_huesped"));
        todos.add(e);
      }
      desconectarDataBase();
      return todos;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando estancias");
    }
    return null;
  }

  public void insertar(Estancia estancia) {
    if (estancia != null){
      String sql = "INSERT INTO estancias (id_cliente, id_casa, "
      + "nombre_huesped, fecha_desde, fecha_hasta) "
      + "VALUES " + getInterrogacion(5);
      try{
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setInt(1, estancia.getIdCliente());
        pStatement.setInt(2, estancia.getIdCasa());
        pStatement.setString(3, estancia.getNombreHuesped());
        pStatement.setDate(4, estancia.getFechaDesde());
        pStatement.setDate(5, estancia.getFechaHasta());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error insertando estancia.");
      }
    }
  }

  public void update(Estancia estancia) {
    if (estancia != null){
      String sql = "UPDATE estancias SET id_cliente = ?, id_casa = ?, "
      + "nombre_huesped = ?, fecha_desde = ?, fecha_hasta = ?"
      + "WHERE id_estancia = ?";
      try{
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setInt(1, estancia.getIdCliente());
        pStatement.setInt(2, estancia.getIdCasa());
        pStatement.setString(3, estancia.getNombreHuesped());
        pStatement.setDate(4, estancia.getFechaDesde());
        pStatement.setDate(5, estancia.getFechaHasta());
        pStatement.setInt(6, estancia.getIdEstancia());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error update estancia.");
      }
    }
  }

  public void eliminarPorId(int id) {
    String sql = "DELETE FROM estancias WHERE id_estancia = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      pStatement.executeUpdate();
      desconectarDataBase();
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error eliminando estancia.");
    }
  }

  public ArrayList<Estancia> getCondicion(String condicion) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCondicion'");
  }
  
}
