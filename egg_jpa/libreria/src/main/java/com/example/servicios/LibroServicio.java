package com.example.servicios;

import java.util.List;

import com.example.entidades.Autor;
import com.example.entidades.Editorial;
import com.example.entidades.Libro;
import com.example.persistencias.LibroDAO;

public class LibroServicio {
  private final LibroDAO dao;

  public LibroServicio(){
    this.dao = new LibroDAO();
  }

  public void crearLibro(
    long isbn,
    String titulo,
    int anio,
    int ejemplares,
    boolean alta,
    Autor autor,
    Editorial editorial
  ){
    try {
      Libro l = new Libro();
      l.setIsbn(isbn);
      l.setTitulo(titulo);
      l.setAnio(anio);
      l.setEjemplares(ejemplares);
      l.setAlta(alta);
      l.setAutor(autor);
      l.setEditorial(editorial);

      dao.guardarLibro(l);
    } catch (Exception e) {
      System.out.println("Error guardando libro");
      System.out.println(e.getMessage());
    }
  }

  public void listarLibros(){
    try {
      List<Libro> todos = dao.listarTodos();
      imprimirLista(todos);
    } catch (Exception e) {
      System.out.println("Error listando libros");
      System.out.println(e.getMessage());
    }
  }

  private void imprimirLista(List<Libro> lista) {
    for (Libro l : lista) {
      System.out.println(l.getIsbn() + " | " + l.getTitulo() + " | " + l.getAutor().getNombre());
    }
  }

  public void buscarPorISBN(long isbn){
    try {
      Libro l = dao.buscarLibro(isbn);
      System.out.println(l.getIsbn() + " | " + l.getTitulo() + " | " + l.getAutor().getNombre());
    } catch (Exception e) {
      System.out.println("Error buscando libro por isbn");
      System.out.println(e.getMessage());
    }
  }

  public void buscarLibroPorTitulo(String titulo){
    try {
      List<Libro> librosTitulo = dao.buscarLibroPorTitulo(titulo);
      imprimirLista(librosTitulo);
    } catch (Exception e) {
      System.out.println("Error buscando libro por isbn");
      System.out.println(e.getMessage());
    }
  }

  public void buscarLibroPorAutor(String autor){
    try {
      List<Libro> librosAutor = dao.buscarLibroPorAutor(autor);
      imprimirLista(librosAutor);
    } catch (Exception e) {
      System.out.println("Error buscando libro por isbn");
      System.out.println(e.getMessage());
    }
  }

  public void cerrar(){
    dao.cerrar();
  }
}
