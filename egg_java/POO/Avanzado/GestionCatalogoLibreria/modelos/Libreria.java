package POO.Avanzado.GestionCatalogoLibreria.modelos;

import java.util.HashSet;
import java.util.Iterator;

public class Libreria {
  HashSet<Libro> libros;

  public Libreria(){
    libros = new HashSet<Libro>();
  }

  public void agregarLibro(Libro libro) {
    if (libros.contains(libro)){
      System.out.println("Ese libro ya está registrado.");
    } else {
      libros.add(libro);
    }
  }

  public void eliminarLibro(String isbn) {
    Libro l = new Libro("", "", isbn);
    if (!libros.contains(l)){
      System.out.println("Ese libro no está en la librería.");
    } else {
      libros.remove(l);
    }
  }

  public void mostrarCatalogo(){
    Iterator<Libro> iterator = libros.iterator();
    while (iterator.hasNext()){
      Libro l = iterator.next();
      System.out.println("- " + l.getTitulo() + " | " + l.getAutor() + " | " + l.getIsbn());
    }
  }
}
