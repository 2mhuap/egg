package servicios;

import entidades.Comentario;
import persistencia.ComentarioDAO;

public class ComentarioServicio {
  private ComentarioDAO dao;

  public ComentarioServicio(){
    this.dao = new ComentarioDAO();
  }

  public Comentario crearComentario(
    int idCasa,
    String comentario
  ) {
    Comentario com = new Comentario(idCasa, comentario);
    dao.insertar(com);
    return com;
  }

  public void listarComentarios(){
    for (Comentario com : dao.getTodos()){
      System.out.println(com);
    }
  }

  public void buscarComentario(int id){
    System.out.println(dao.getPorId(id));
  }

  public void eliminarComentario(int id){
    dao.eliminarPorId(id);
  }

  public Comentario modificarComentario(
    int id,
    int idCasa,
    String comentario
  ) {
    Comentario com = new Comentario(id, idCasa, comentario);
    dao.update(com);
    return com;
  }
}
