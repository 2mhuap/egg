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
@Table(name = "detalle_pedido")
public class DetallePedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_detalle_pedido")
  private int idDetallePedido;

  @ManyToOne
  @JoinColumn(name = "id_pedido")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "id_producto")
  private Producto producto;

  private int cantidad;

  @Column(name = "precio_unidad")
  private double precioUnidad;

  @Column(name = "numero_linea")
  private int numeroLinea;

  public DetallePedido() {
  }

  public int getIdDetallePedido() {
    return idDetallePedido;
  }

  public void setIdDetallePedido(int idDetallePedido) {
    this.idDetallePedido = idDetallePedido;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecioUnidad() {
    return precioUnidad;
  }

  public void setPrecioUnidad(double precioUnidad) {
    this.precioUnidad = precioUnidad;
  }

  public int getNumeroLinea() {
    return numeroLinea;
  }

  public void setNumeroLinea(int numeroLinea) {
    this.numeroLinea = numeroLinea;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  
  
}
