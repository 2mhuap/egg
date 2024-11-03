package com.example.servicios;

import java.util.List;

import com.example.entidades.Editorial;
import com.example.persistencias.EditorialDAO;

public class EditorialServicio {
  private final EditorialDAO dao;

  public EditorialServicio(){
    this.dao = new EditorialDAO();
  }

  public void crearEditorial(String nombre){
    try {
      Editorial e = new Editorial();
      e.setNombre(nombre);
      e.setAlta(false);

      dao.guardarEditorial(e);
    } catch (Exception e) {
      System.out.println("Error creando editorial");
      System.out.println(e.getMessage());
    }
  }

  public void modificarEditorial(String nombre){
    try {
      Editorial e = new Editorial();
      e.setNombre(nombre);
      e.setAlta(false);

      dao.modificarEditorial(e);
    } catch (Exception e) {
      System.out.println("Error modificando editorial");
      System.out.println(e.getMessage());
    }
  }

  public void borrarEditorial(int id){
    try {
      dao.borrarEditorial(id);
    } catch (Exception e) {
      System.out.println("Error borrando editorial");
      System.out.println(e.getMessage());
    }
  }

  public void listarEditoriales(){
    try {
      List<Editorial> todos = dao.listarTodos();
      imprimirLista(todos);
    } catch (Exception e) {
      System.out.println("Error listando autores");
      System.out.println(e.getMessage());
    }
  }

  private void imprimirLista(List<Editorial> todos) {
    for (Editorial e : todos) {
      System.out.println(e.getId() + " | " + e.getNombre());
    }
  }

  public Editorial buscarEditorialPorId(int id){
    try {
      Editorial e = dao.buscarEditorial(id);
      return e;
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
