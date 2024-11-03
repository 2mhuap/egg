package POO.Avanzado.GestionBiblioteca.modelos;

import java.util.ArrayList;

public class Persona {
  private String nombre;
  private String apellido;
  private ArrayList<Libro> librosPrestados = new ArrayList<>();

  public Persona(String nombre, String apellido) {
    this.nombre = nombre;
    this.apellido = apellido;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public ArrayList<Libro> getLibrosPrestados() {
    return librosPrestados;
  }

  public void prestarLibro(Libro libro){
    if (libro.prestar()){
      librosPrestados.add(libro);
    }
  }

  public void devolverLibro(Libro libro){
    if (libro.isPrestado()){
      librosPrestados.remove(libro);
    }
  }
  
}
