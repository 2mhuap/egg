package servicios;

import java.sql.Date;
import java.util.ArrayList;

import entidades.Casa;
import persistencia.CasaDAO;

public class CasaServicio {
  private CasaDAO dao;

  public CasaServicio(){
    this.dao = new CasaDAO();
  }

  public Casa crearCasa(
    String calle,
    int numero,
    String codigoPostal,
    String ciudad,
    String pais,
    Date fechaDesde,
    Date fechaHasta,
    int tiempoMinimo,
    int tiempoMaximo,
    double precioHabitacion,
    String tipoVivienda
  ) {
    Casa casa = new Casa(calle, numero, codigoPostal, ciudad, pais, fechaDesde, fechaHasta, tiempoMinimo, tiempoMaximo, precioHabitacion, tipoVivienda);
    dao.insertar(casa);
    return casa;
  }

  public void listarCasas(){
    for (Casa casa : dao.getTodos()) {
      System.out.println(casa);
    }
  }

  public void listarCasasCondicion(String condicion){
    ArrayList<Casa> resultado = dao.getCondicion(condicion);
    if (resultado.size() > 0){
      for (Casa casa : resultado) {
        System.out.println(casa);
      }
    } else {
      System.out.println("Ninguna casa cumple esa condición.");
    }
  }

  public ArrayList<String> listarPaises(){
    ArrayList<String> resultado = dao.getPaises();
    for (int i = 0; i < resultado.size(); i++) {
      System.out.println((i + 1) + ". " + resultado.get(i));
    }
    return resultado;
  }

  public void buscarCasa(int id){
    System.out.println(dao.getPorId(id));
  }

  public void eliminarCasa(int id){
    dao.eliminarPorId(id);
  }

  public Casa modificarCasa(
    int id,
    String calle,
    int numero,
    String codigoPostal,
    String ciudad,
    String pais,
    Date fechaDesde,
    Date fechaHasta,
    int tiempoMinimo,
    int tiempoMaximo,
    double precioHabitacion,
    String tipoVivienda
  ) {
    Casa casa = new Casa(id, calle, numero, codigoPostal, ciudad, pais, fechaDesde, fechaHasta, tiempoMinimo, tiempoMaximo, precioHabitacion, tipoVivienda);
    dao.update(casa);
    return casa;
  }
}
