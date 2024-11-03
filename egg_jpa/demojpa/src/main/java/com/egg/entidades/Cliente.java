package com.egg.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cliente")
  private int idCliente;

  @Column(name = "codigo_cliente")
  private int codigoCliente;

  @Column(name = "nombre_cliente")
  private String nombreCliente;

  @Column(name = "nombre_contacto")
  private String nombreContacto;

  @Column(name = "apellido_contacto")
  private String apellidoContacto;

  private String telefono;
  private String fax;
  private String ciudad;
  private String region;
  private String pais;

  @Column(name = "codigo_postal")
  private String codigoPostal;

  @Column(name = "id_empleado")
  private int idEmpleado;

  @Column(name = "limite_credito")
  private double limiteCredito;

  public Cliente() {
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public int getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(int codigoCliente) {
    this.codigoCliente = codigoCliente;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public String getNombreContacto() {
    return nombreContacto;
  }

  public void setNombreContacto(String nombreContacto) {
    this.nombreContacto = nombreContacto;
  }

  public String getApellidoContacto() {
    return apellidoContacto;
  }

  public void setApellidoContacto(String apellidoContacto) {
    this.apellidoContacto = apellidoContacto;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public int getIdEmpleado() {
    return idEmpleado;
  }

  public void setIdEmpleado(int idEmpleado) {
    this.idEmpleado = idEmpleado;
  }

  public double getLimiteCredito() {
    return limiteCredito;
  }
  
  public void setLimiteCredito(double limiteCredito) {
    this.limiteCredito = limiteCredito;
  }

  @Override
  public String toString() {
    String s = "";
    s += "Cliente:";
    s += "\nidCliente: " + idCliente;
    s += "\ncodigoCliente: " + codigoCliente;
    s += "\nnombreCliente: " + nombreCliente;
    s += "\nnombreContacto: " + nombreContacto;
    s += "\napellidoContacto: " + apellidoContacto;
    // System.out.println("telefono: " + telefono);
    // System.out.println("fax: " + fax);
    // System.out.println("ciudad: " + ciudad);
    // System.out.println("region: " + region);
    // System.out.println("pais: " + pais);
    // System.out.println("codigoPostal: " + codigoPostal);
    // System.out.println("idEmpleado: " + idEmpleado);
    // System.out.println("limiteCredito: " + limiteCredito);
    return s;
  }
}
