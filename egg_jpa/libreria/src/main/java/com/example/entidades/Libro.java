package com.example.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
  @Id
  private long isbn;

  private String titulo;
  private int anio;
  private int ejemplares;
  private boolean alta;

  @ManyToOne
  @JoinColumn(name = "id_autor")
  private Autor autor;

  @ManyToOne
  @JoinColumn(name = "id_editorial")
  private Editorial editorial;

  public Libro() {
  }

  public long getIsbn() {
    return isbn;
  }

  public void setIsbn(long isbn) {
    this.isbn = isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getAnio() {
    return anio;
  }

  public void setAnio(int anio) {
    this.anio = anio;
  }

  public int getEjemplares() {
    return ejemplares;
  }

  public void setEjemplares(int ejemplares) {
    this.ejemplares = ejemplares;
  }

  public boolean isAlta() {
    return alta;
  }

  public void setAlta(boolean alta) {
    this.alta = alta;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public Editorial getEditorial() {
    return editorial;
  }

  public void setEditorial(Editorial editorial) {
    this.editorial = editorial;
  }
  
  
}
