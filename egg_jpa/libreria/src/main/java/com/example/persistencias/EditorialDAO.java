package com.example.persistencias;

import java.util.List;

import com.example.entidades.Editorial;

public class EditorialDAO extends DAO {
  public void guardarEditorial(Editorial editorial) throws Exception {
    em.getTransaction().begin();
    em.persist(editorial);
    em.getTransaction().commit();
  }

  public List<Editorial> listarTodos() throws Exception {
    return em.createQuery("SELECT e FROM Editorial e", Editorial.class)
      .getResultList();
  }

  public void modificarEditorial(Editorial editorial) throws Exception {
    em.getTransaction().begin();
    em.merge(editorial);
    em.getTransaction().commit();
  }

  public void borrarEditorial(int id) throws Exception {
    em.getTransaction().begin();
    Editorial e = em.find(Editorial.class, id);
    em.remove(e);
    em.getTransaction().commit();
  }

  public Editorial buscarEditorial(int id) throws Exception {
    return em.find(Editorial.class, id);
  }
}
