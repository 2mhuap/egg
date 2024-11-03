package com.egg.servicios;

import com.egg.persistencia.PedidoDAO;
import com.egg.entidades.Pedido;
import java.util.List;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class PedidoServicio {
  private final PedidoDAO dao;

  public PedidoServicio(){
    this.dao = new PedidoDAO();
  }

  public void listarPedidosEntregadosDespues(Date fecha) {
    try {
      List<Pedido> pedidosDespues = dao.listarPedidosEntregadosDespuesDe(fecha);
      imprimirLista(pedidosDespues);
    } catch (Exception e) {
      System.out.println("Error listando pedidos fecha=" + fecha);
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  private void imprimirLista(List<Pedido> lista) {
    for (Pedido p : lista) {
      Date entrega = p.getFechaEntrega();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
      sdf.setTimeZone(TimeZone.getTimeZone("PET"));
      String fechaString = sdf.format(entrega);
      sdf.setTimeZone(TimeZone.getDefault());
      System.out.println(p.getCodigoPedido() + " | " + fechaString);
    }
  }
}
