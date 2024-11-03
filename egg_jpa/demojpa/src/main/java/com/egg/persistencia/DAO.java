package com.egg.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class DAO {
  protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
  protected final EntityManager em = emf.createEntityManager();

  public void cerrar(){
    em.close();
    emf.close();
  }
}
