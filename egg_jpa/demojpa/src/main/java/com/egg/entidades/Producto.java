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
@Table(name = "producto")
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private int idProducto;

  @Column(name = "codigo_producto")
  private String codigoProducto;

  private String nombre;

  @ManyToOne
  @JoinColumn(name = "id_gama")
  private GamaProducto gama;

  private String dimensiones;
  private String proveedor;
  private String descripcion;

  @Column(name = "cantidad_en_stock")
  private int cantidadEnStock;

  @Column(name = "precio_venta")
  private double precioVenta;

  @Column(name = "precio_proveedor")
  private double precioProveedor;

  public Producto() {
  }

  public int getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
  }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDimensiones() {
    return dimensiones;
  }

  public void setDimensiones(String dimensiones) {
    this.dimensiones = dimensiones;
  }

  public String getProveedor() {
    return proveedor;
  }

  public void setProveedor(String proveedor) {
    this.proveedor = proveedor;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getCantidadEnStock() {
    return cantidadEnStock;
  }

  public void setCantidadEnStock(int cantidadEnStock) {
    this.cantidadEnStock = cantidadEnStock;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(double precioVenta) {
    this.precioVenta = precioVenta;
  }

  public double getPrecioProveedor() {
    return precioProveedor;
  }

  public void setPrecioProveedor(double precioProveedor) {
    this.precioProveedor = precioProveedor;
  }

  public GamaProducto getGama() {
    return gama;
  }

  public void setGama(GamaProducto gama) {
    this.gama = gama;
  }
}
