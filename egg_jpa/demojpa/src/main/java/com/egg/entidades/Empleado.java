package com.egg.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_empleado")
  private int idEmpleado;

  @Column(name = "codigo_empleado")
  private int codigoEmpleado;

  private String nombre;
  private String apellido;
  private String extension;
  private String email;

  @ManyToOne
  @JoinColumn(name = "id_oficina")
  private Oficina oficina;

  @Column(name = "id_jefe")
  private int idJefe;

  private String puesto;

  public Empleado() {
  }

  public int getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public int getCodigoEmpleado() {
    return codigoEmpleado;
  }

  public void setCodigoEmpleado(int codigoEmpleado) {
    this.codigoEmpleado = codigoEmpleado;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getIdJefe() {
    return idJefe;
  }

  public void setIdJefe(int idJefe) {
    this.idJefe = idJefe;
  }

  public String getPuesto() {
    return puesto;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }

  public Oficina getOficina() {
    return oficina;
  }

  public void setOficina(Oficina oficina) {
    this.oficina = oficina;
  }

  
}
