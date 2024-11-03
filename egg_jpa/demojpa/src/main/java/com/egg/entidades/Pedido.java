package com.egg.entidades;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pedido")
  private int idPedido;

  @Column(name = "codigo_pedido")
  private int codigoPedido;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "fecha_pedido")
  private Date fechaPedido;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "fecha_esperada")
  private Date fechaEsperada;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "fecha_entrega")
  private Date fechaEntrega;

  private String estado;
  private String comentarios;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  public Pedido() {
  }

  public int getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public int getCodigoPedido() {
    return codigoPedido;
  }

  public void setCodigoPedido(int codigoPedido) {
    this.codigoPedido = codigoPedido;
  }

  public Date getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(Date fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public Date getFechaEsperada() {
    return fechaEsperada;
  }

  public void setFechaEsperada(Date fechaEsperada) {
    this.fechaEsperada = fechaEsperada;
  }

  public Date getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(Date fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getComentarios() {
    return comentarios;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  
}
