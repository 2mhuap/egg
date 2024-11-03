package com.egg.persistencia;

import java.util.List;

import com.egg.entidades.Pedido;
import java.util.Date;

public class PedidoDAO extends DAO{
  public List<Pedido> listarPedidosEntregadosDespuesDe(Date fecha){
    return em.createQuery("SELECT p FROM Pedido p WHERE p.fechaEntrega > :fecha", Pedido.class)
      .setParameter("fecha", fecha)
      .getResultList();
  }
}
