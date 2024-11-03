package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Comentario;

public class ComentarioDAO extends DAO<Comentario> {

  public Comentario getPorId(int id) {
    String sql = "SELECT id_comentario, id_casa, comentario FROM comentarios WHERE id_comentario = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      resultSet = pStatement.executeQuery();
      Comentario c = null;
      if (resultSet.next()){
        c = new Comentario();
        c.setIdComentario(resultSet.getInt("id_comentario"));
        c.setIdCasa(resultSet.getInt("id_casa"));
        c.setComentario(resultSet.getString("comentario"));
      }
      desconectarDataBase();
      return c;
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error getPorId comentario");
    }
    return null;
  }

  public ArrayList<Comentario> getTodos() {
    String sql = "SELECT id_comentario, id_casa, comentario FROM comentarios";
    try {
      consultarDataBase(sql);
      ArrayList<Comentario> todos = new ArrayList<>();
      while (resultSet.next()){
        Comentario c = new Comentario();
        c.setIdComentario(resultSet.getInt("id_comentario"));
        c.setIdCasa(resultSet.getInt("id_casa"));
        c.setComentario(resultSet.getString("comentario"));
        todos.add(c);
      }
      desconectarDataBase();
      return todos;
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error listando comentarios");
    }
    return null;
  }

  @Override
  public void insertar(Comentario comentario) {
    if (comentario != null){
      String sql = "INSERT INTO comentarios (id_casa, comentario) "
      + "VALUES " + getInterrogacion(2);
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setInt(1, comentario.getIdCasa());
        pStatement.setString(2, comentario.getComentario());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error insertando comentario.");
      }
    }
  }

  public void update(Comentario comentario) {
    if (comentario != null){
      String sql = "UPDATE comentarios SET id_casa = ?, comentario = ? "
      + "WHERE id_comentario = ?";
      try {
        connectarDataBase();
        pStatement = conexion.prepareStatement(sql);
        pStatement.setInt(1, comentario.getIdCasa());
        pStatement.setString(2, comentario.getComentario());
        pStatement.setInt(3, comentario.getIdComentario());
        pStatement.executeUpdate();
        desconectarDataBase();
      } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error update comentario.");
      }
    }
  }

  public void eliminarPorId(int id) {
    String sql = "DELETE FROM comentarios WHERE id_comentario = ?";
    try {
      connectarDataBase();
      pStatement = conexion.prepareStatement(sql);
      pStatement.setInt(1, id);
      pStatement.executeUpdate();
      desconectarDataBase();
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error eliminando comentario.");
    }
  }

  public ArrayList<Comentario> getCondicion(String condicion) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCondicion'");
  }
  
}
