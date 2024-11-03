package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class DAO<T> {
  protected Connection conexion = null;
  protected ResultSet resultSet = null;
  protected Statement statement = null;
  protected PreparedStatement pStatement = null;
  private final String HOST = "127.0.0.1";
  private final String PORT = "3306";
  private final String USER = "root";
  private final String PASSWORD = "mySql3gg";
  private final String DATABASE = "estancias_exterior";
  private final String DRIVER = "com.mysql.cj.jdbc.Driver";

  protected void connectarDataBase() throws SQLException, ClassNotFoundException {
      try {
          Class.forName(DRIVER);
          String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
          conexion = DriverManager.getConnection(url, USER, PASSWORD);
          // System.out.println("Conexión exitosa a la base de datos.");
      } catch (Exception e) {
          System.out.println(e.getMessage());
          throw e;
      }
  }

  protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
      try {
          if (resultSet != null) {
              resultSet.close();
          }
          if (statement != null) {
            statement.close();
          }
          if (pStatement != null) {
              pStatement.close();
          }
          if (conexion != null) {
              conexion.close();
          }

          // System.out.println("La conexión a la base fue cerrada de manera correcta");
      } catch (Exception e) {
          System.out.println(e.getMessage());
          throw e;
      }
  }

  abstract public T getPorId(int id);
  abstract public ArrayList<T> getTodos();
  abstract public ArrayList<T> getCondicion(String condicion);
  abstract public void insertar(T entidad);
  abstract public void update(T entidad);
  abstract public void eliminarPorId(int id);

  protected void insertarModificarEliminarDataBase(String sql) throws SQLException, ClassNotFoundException {
    try {
      connectarDataBase();
      statement = conexion.createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error DAO.insertarModificarEliminarDataBase:");
      System.out.println(e.getMessage());
      throw e;
    } finally {
      desconectarDataBase();
    }
  }

  protected void consultarDataBase(String sql) throws SQLException, ClassNotFoundException {
    try {
      connectarDataBase();
      statement = conexion.createStatement();
      resultSet = statement.executeQuery(sql);
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("Error DAO.consultarDataBase:");
      System.out.println(e.getMessage());
      throw e;
    } 
    // finally {
    //   desconectarDataBase();
    // }
  }

  protected String getInterrogacion(int n){
    String s = "(";
    for (int i = 0; i < n; i++) {
      s += "?";
      if (i != n - 1){
        s += ",";
      }
    }
    s += ")";
    return s;
  }
}