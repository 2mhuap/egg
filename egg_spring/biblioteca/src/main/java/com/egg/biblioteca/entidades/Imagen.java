package com.egg.biblioteca.entidades;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Imagen {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String nombre;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(columnDefinition = "LONGBLOB")
  private byte[] contenido;

  public Imagen() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public byte[] getContenido() {
    return contenido;
  }

  public void setContenido(byte[] contenido) {
    this.contenido = contenido;
  }

  
}
