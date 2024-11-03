package POO.Avanzado.GestionBiblioteca.modelos;

import java.util.ArrayList;

public class Biblioteca {
  private ArrayList<Libro> libros = new ArrayList<Libro>();

  public ArrayList<Libro> getLibros() {
    return libros;
  }

  public void agregarLibro(Libro libro){
    libros.add(libro);
  }

  public void mostrarLibros(){
    for (Libro libro : libros) {
      libro.obtenerInformacion();
    }
  }

}
