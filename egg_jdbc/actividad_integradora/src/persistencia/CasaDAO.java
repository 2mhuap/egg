package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Casa;

public class CasaDAO extends DAO<Casa> {
  public void insertar(Casa casa){
    if (casa != null){
      String sql = "INSERT INTO casas (calle, numero, codigo_postal, " //3
      + "ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, " //5
      + "tiempo_maximo, precio_habitacion, tipo_vivienda) " //3
      + "VALUES " + getInterrogacion(11);
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setString(1, casa.getCalle());
        pStatement.setInt(2, casa.getNumero());
        pStatement.setString(3, casa.getCodigoPostal());
        pStatement.setString(4, casa.getCiudad());
        pStatement.setString(5, casa.getPais());
        pStatement.setDate(6, casa.getFechaDesde());
        pStatement.setDate(7, casa.getFechaHasta());
        pStatement.setInt(8, casa.getTiempoMinimo());
        pStatement.setInt(9, casa.getTiempoMaximo());
        pStatement.setDouble(10, casa.getPrecioHabitacion());
        pStatement.setString(11, casa.getTipoVivienda());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error insertando casa.");
      }
    }
  }

  public ArrayList<Casa> getTodos(){
    String sql = "SELECT id_casa, calle, numero, ciudad FROM casas";
    try {
      consultarDataBase(sql);
      ArrayList<Casa> todos = new ArrayList<>();
      while (resultSet.next()){
        Casa c = new Casa();
        c.setIdCasa(resultSet.getInt("id_casa"));
        c.setCalle(resultSet.getString("calle"));
        c.setNumero(resultSet.getInt("numero"));
        c.setCiudad(resultSet.getString("ciudad"));
        todos.add(c);
      }
      desconectarDataBase();
      return todos;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando casas");
    }
    return null;
  }

  public ArrayList<Casa> getCondicion(String condicion){
    String sql = "SELECT id_casa, calle, numero, ciudad FROM casas WHERE " + condicion;
    try {
      consultarDataBase(sql);
      ArrayList<Casa> todos = new ArrayList<>();
      while (resultSet.next()){
        Casa c = new Casa();
        c.setIdCasa(resultSet.getInt("id_casa"));
        c.setCalle(resultSet.getString("calle"));
        c.setNumero(resultSet.getInt("numero"));
        c.setCiudad(resultSet.getString("ciudad"));
        todos.add(c);
      }
      desconectarDataBase();
      return todos;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando casas con condicion");
    }
    return null;
  }

  public Casa getPorId(int id) {
    String sql = "SELECT id_casa, calle, numero, ciudad FROM casas WHERE id_casa = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      resultSet = pStatement.executeQuery();
      Casa c = null;
      if (resultSet.next()){
        c = new Casa();
        c.setIdCasa(resultSet.getInt("id_casa"));
        c.setCalle(resultSet.getString("calle"));
        c.setNumero(resultSet.getInt("numero"));
        c.setCiudad(resultSet.getString("ciudad"));
      }
      desconectarDataBase();
      return c;
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error getPorId casa");
    }
    return null;
  }

  public void update(Casa casa) {
    if (casa != null){
      String sql = "UPDATE casas SET calle = ?, numero = ?, codigo_postal = ?, ciudad = ?, "
        + "pais = ?, fecha_desde = ?, fecha_hasta = ?, tiempo_minimo = ?, tiempo_maximo = ?, "
        + "precio_habitacion = ?, tipo_vivienda = ? "
        + "WHERE id_casa = ?";
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setString(1, casa.getCalle());
        pStatement.setInt(2, casa.getNumero());
        pStatement.setString(3, casa.getCodigoPostal());
        pStatement.setString(4, casa.getCiudad());
        pStatement.setString(5, casa.getPais());
        pStatement.setDate(6, casa.getFechaDesde());
        pStatement.setDate(7, casa.getFechaHasta());
        pStatement.setInt(8, casa.getTiempoMinimo());
        pStatement.setInt(9, casa.getTiempoMaximo());
        pStatement.setDouble(10, casa.getPrecioHabitacion());
        pStatement.setString(11, casa.getTipoVivienda());
        pStatement.setInt(12, casa.getIdCasa());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error modificando casa.");
      }
    }
  }

  public void eliminarPorId(int id) {
    String sql = "DELETE FROM casas WHERE id_casa = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      pStatement.executeUpdate();
      desconectarDataBase();
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error eliminando casa.");
    }
  }

  public ArrayList<String> getPaises(){
    String sql = "SELECT DISTINCT pais FROM casas";
    try {
      consultarDataBase(sql);
      ArrayList<String> paises = new ArrayList<>();
      while (resultSet.next()){
        paises.add(resultSet.getString("pais"));
      }
      desconectarDataBase();
      return paises;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando casas");
    }
    return null;
  }
}
