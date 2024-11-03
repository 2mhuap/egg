package com.example.servicios;

import java.util.List;

import com.example.entidades.Autor;
import com.example.persistencias.AutorDAO;

public class AutorServicio {
  private final AutorDAO dao;

  public AutorServicio(){
    this.dao = new AutorDAO();
  }

  public void crearAutor(String nombre, boolean alta) {
    try {
      Autor a = new Autor();
      a.setNombre(nombre);
      a.setAlta(alta);

      dao.guardarAutor(a);
    } catch (Exception e) {
      System.out.println("Error guardando autor");
      System.out.println(e.getMessage());
    }
  }

  public void modificarAutor(int id, String nombre, boolean alta) {
    try {
      Autor a = new Autor();
      a.setId(id);
      a.setNombre(nombre);
      a.setAlta(alta);

      dao.modificarAutor(a);
    } catch (Exception e) {
      System.out.println("Error modificando autor");
      System.out.println(e.getMessage());
    }
  }

  public void borrarAutor(int id) {
    try {
      dao.borrarAutor(id);
    } catch (Exception e) {
      System.out.println("Error borrando autor");
      System.out.println(e.getMessage());
    }
  }

  public void listarAutores(){
    try {
      List<Autor> todos = dao.listarTodos();
      imprimirLista(todos);
    } catch (Exception e) {
      System.out.println("Error listando autores");
      System.out.println(e.getMessage());
    }
  }

  private void imprimirLista(List<Autor> lista) {
    for (Autor a : lista) {
      System.out.println(a.getId() + " | " + a.getNombre());
    }
  }

  public void buscarAutorPorNombre(String nombre) {
    try {
      List<Autor> autoresNombre = dao.buscarAutor(nombre);
      imprimirLista(autoresNombre);
    } catch (Exception e) {
      System.out.println("Error listando autores");
      System.out.println(e.getMessage());
    }
  }

  public Autor buscarAutorPorId(int id) {
    try {
      Autor a = dao.buscarAutor(id);
      return a;
    } catch (Exception e) {
      System.out.println("Error listando autores");
      System.out.println(e.getMessage());
    }
    return null;
  }

  public void cerrar(){
    dao.cerrar();
  }
}
