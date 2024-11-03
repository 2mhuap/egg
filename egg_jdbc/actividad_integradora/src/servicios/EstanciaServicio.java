package servicios;

import java.sql.Date;

import entidades.Estancia;
import persistencia.EstanciaDAO;

public class EstanciaServicio {
  private EstanciaDAO dao;

  public EstanciaServicio(){
    this.dao = new EstanciaDAO();
  }

  public Estancia crearEstancia(
    int idCliente,
    int idCasa,
    String nombreHuesped,
    Date fechaDesde,
    Date fechaHasta
  ){
    Estancia est = new Estancia(idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);
    dao.insertar(est);
    return est;
  }

  public void listarEstancias(){
    for (Estancia est : dao.getTodos()){
      System.out.println(est);
    }
  }

  public void buscarEstancia(int id){
    System.out.println(dao.getPorId(id));
  }

  public void eliminarEstancia(int id){
    dao.eliminarPorId(id);
  }

  public Estancia modificarEstancia(
    int id,
    int idCliente,
    int idCasa,
    String nombreHuesped,
    Date fechaDesde,
    Date fechaHasta
  ){
    Estancia est = new Estancia(id, idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);
    dao.update(est);
    return est;
  }

}
