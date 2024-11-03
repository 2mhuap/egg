package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Familia;

public class FamiliaDAO extends DAO<Familia> {

  public Familia getPorId(int id) {
    String sql = "SELECT id_familia, nombre, id_casa_familia FROM familias WHERE id_familia = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      resultSet = pStatement.executeQuery();
      Familia f = null;
      if (resultSet.next()){
        f = new Familia();
        f.setIdFamilia(id);
        f.setNombre(resultSet.getString("nombre"));
        f.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
      }
      desconectarDataBase();
      return f;
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error getPorId familia");
    }
    return null;
  }

  public ArrayList<Familia> getCondicion(String condicion){
    String sql = "SELECT id_familia, nombre, email, id_casa_familia FROM familias WHERE " + condicion;
    try {
      consultarDataBase(sql);
      ArrayList<Familia> todos = new ArrayList<>();
      while (resultSet.next()){
        Familia f = new Familia();
        f.setIdFamilia(resultSet.getInt("id_familia"));
        f.setNombre(resultSet.getString("nombre"));
        f.setEmail(resultSet.getString("email"));
        f.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        todos.add(f);
      }
      desconectarDataBase();
      return todos;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando familias con condición");
    }
    return null;
  }

  public ArrayList<Familia> getTodos() {
    String sql = "SELECT id_familia, nombre, id_casa_familia FROM familias";
    try {
      consultarDataBase(sql);
      ArrayList<Familia> todos = new ArrayList<>();
      while (resultSet.next()){
        Familia f = new Familia();
        f.setIdFamilia(resultSet.getInt("id_familia"));
        f.setNombre(resultSet.getString("nombre"));
        f.setIdCasaFamilia(resultSet.getInt("id_casa_familia"));
        todos.add(f);
      }
      desconectarDataBase();
      return todos;
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error listando familias");
    }
    return null;
  }

  public void insertar(Familia familia) {
    if (familia != null){
      String sql = "INSERT INTO familias (nombre, edad_minima, edad_maxima, "
      + "num_hijos, email, id_casa_familia) "
      + "VALUES " + getInterrogacion(6);
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setString(1, familia.getNombre());
        pStatement.setInt(2, familia.getEdadMinima());
        pStatement.setInt(3, familia.getEdadMaxima());
        pStatement.setInt(4, familia.getNumHijos());
        pStatement.setString(5, familia.getEmail());
        pStatement.setInt(6, familia.getIdCasaFamilia());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error insertando familia.");
      }
    }
  }

  public void update(Familia familia) {
    if (familia != null){
      String sql = "UPDATE familias SET nombre = ?, edad_minima = ?, edad_maxima = ?, "
      + "num_hijos = ?, email = ?, id_casa_familia = ? "
      + "WHERE id_familia = ?";
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setString(1, familia.getNombre());
        pStatement.setInt(2, familia.getEdadMinima());
        pStatement.setInt(3, familia.getEdadMaxima());
        pStatement.setInt(4, familia.getNumHijos());
        pStatement.setString(5, familia.getEmail());
        pStatement.setInt(6, familia.getIdCasaFamilia());
        pStatement.setInt(7, familia.getIdFamilia());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error update familia.");
      }
    }
  }

  public void eliminarPorId(int id) {
    String sql = "DELETE FROM familias WHERE id_familia = ?";
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
  
}
