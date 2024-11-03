package com.egg.persistencia;

import java.util.List;
import com.egg.entidades.GamaProducto;

public class GamaProductoDAO extends DAO {
  
  public void guardaGamaProducto(GamaProducto gama) throws Exception {
    em.getTransaction().begin();
    em.persist(gama);
    em.getTransaction().commit();
  }

  public GamaProducto buscarGamaProducto(int id) throws Exception {
    GamaProducto g = em.find(GamaProducto.class, id);
    return g;
  }

  public void modificarGamaProducto(GamaProducto gama) throws Exception {
    em.getTransaction().begin();
    em.merge(gama);
    em.getTransaction().commit();
  }

  public void borrarGamaProducto(int id) throws Exception {
    em.getTransaction().begin();
    GamaProducto g = em.find(GamaProducto.class, id);
    em.remove(g);
    em.getTransaction().commit();
  } 

  public List<GamaProducto> listarTodas() throws Exception {
    return em.createQuery("SELECT g FROM GamaProducto g", GamaProducto.class)
      .getResultList();
  }
}
