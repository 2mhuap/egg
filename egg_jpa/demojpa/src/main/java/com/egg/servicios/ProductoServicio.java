package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;

public class ProductoServicio {
  private final ProductoDAO dao;

  public ProductoServicio(){
    this.dao = new ProductoDAO();
  }

  public void listarProductos() {
    try {
      List<Producto> todos = dao.listarTodos();
      imprimirLista(todos);
    } catch (Exception e) {
      System.out.println("Error listando productos");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  private void imprimirLista(List<Producto> lista) {
    for (Producto p : lista) {
      System.out.println(p.getCodigoProducto() + " | " + p.getNombre());
    }
  }
}
