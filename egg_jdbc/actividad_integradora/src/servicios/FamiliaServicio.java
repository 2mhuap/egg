package servicios;

import java.util.ArrayList;

import entidades.Familia;
import persistencia.FamiliaDAO;

public class FamiliaServicio {
  private FamiliaDAO dao;

  public FamiliaServicio(){
    this.dao = new FamiliaDAO();
  }

  public Familia crearFamilia(
    String nombre,
    int edadMinima,
    int edadMaxima,
    int numHijos,
    String email,
    int idCasaFamilia
  ) {
    Familia fam = new Familia(nombre, edadMinima, edadMaxima, numHijos, email, idCasaFamilia);
    dao.insertar(fam);
    return fam;
  }

  public void listarFamilias(){
    for (Familia fam : dao.getTodos()){
      System.out.println(fam);
    }
  }

  public void buscarFamilia(int id){
    System.out.println(dao.getPorId(id));
  }

  public void listarFamiliasCondicion(String condicion){
    ArrayList<Familia> resultado = dao.getCondicion(condicion);
    if (resultado.size() > 0){
      for (Familia fam : resultado ){
        System.out.println(fam);
      }
    } else {
      System.out.println("Ninguna familia cumple esa condición.");
    }
  }

  public void eliminarFamilia(int id){
    dao.eliminarPorId(id);
  }

  public Familia modificarFamilia(
    int id,
    String nombre,
    int edadMinima,
    int edadMaxima,
    int numHijos,
    String email,
    int idCasaFamilia
  ) {
    Familia fam = new Familia(id, nombre, edadMinima, edadMaxima, numHijos, email, idCasaFamilia);
    dao.update(fam);
    return fam;
  }
}
