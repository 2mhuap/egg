package com.example.persistencias;

import java.util.List;

import org.glassfish.jaxb.core.v2.TODO;

import com.example.entidades.Libro;

public class LibroDAO extends DAO {

  public void guardarLibro(Libro libro) throws Exception {
    em.getTransaction().begin();
    em.persist(libro);
    em.getTransaction().commit();
  }

  public Libro buscarLibro(long isbn) throws Exception {
    return em.find(Libro.class, isbn);
  }

  public List<Libro> buscarLibroPorTitulo(String titulo) throws Exception {
    return em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class)
      .setParameter("titulo", "%" + titulo + "%")
      .getResultList();
  }

  public List<Libro> buscarLibroPorAutor(String autor) throws Exception {
    return em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor", Libro.class)
      .setParameter("autor", "%" + autor + "%")
      .getResultList();
  }

  // TODO buscarPorNombreEditorial

  public List<Libro> listarTodos() throws Exception {
    return em.createQuery("SELECT l FROM Libro l", Libro.class)
      .getResultList();
  }

  public void modificarLibro(Libro libro) throws Exception {
    em.getTransaction().begin();
    em.merge(libro);
    em.getTransaction().commit();
  }

  public void borrarLibro(int id) throws Exception {
    em.getTransaction().begin();
    Libro l = em.find(Libro.class, id);
    em.remove(l);
    em.getTransaction().commit();
  }
  
}
