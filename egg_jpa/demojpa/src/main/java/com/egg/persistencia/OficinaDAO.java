package com.egg.persistencia;

import com.egg.entidades.Oficina;

import java.util.List;

public class OficinaDAO extends DAO {
  
  public void guardaOficina(Oficina oficina) throws Exception {
    em.getTransaction().begin();
    em.persist(oficina);
    em.getTransaction().commit();
  }

  public List<Oficina> listarTodas() throws Exception {
    return em.createQuery("SELECT o FROM Oficina o", Oficina.class)
      .getResultList();
  }
}
