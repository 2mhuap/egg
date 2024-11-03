package com.example.persistencias;

import java.util.List;
import com.example.entidades.Autor;

public class AutorDAO extends DAO {
  
  public void guardarAutor(Autor autor) throws Exception {
    em.getTransaction().begin();
    em.persist(autor);
    em.getTransaction().commit();
  }

  public List<Autor> buscarAutor(String nombre) throws Exception{
    return em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre", Autor.class)
      .setParameter("nombre", "%" + nombre + "%")
      .getResultList();
  }

  public Autor buscarAutor(int id) throws Exception{
    return em.find(Autor.class, id);
  }

  public void modificarAutor(Autor autor) throws Exception {
    em.getTransaction().begin();
    em.merge(autor);
    em.getTransaction().commit();
  }

  public void borrarAutor(int id) throws Exception {
    em.getTransaction().begin();
    Autor a = em.find(Autor.class, id);
    em.remove(a);
    em.getTransaction().commit();
  }

  public List<Autor> listarTodos(){
    return em.createQuery("SELECT a FROM Autor a", Autor.class)
      .getResultList();
  }
}
