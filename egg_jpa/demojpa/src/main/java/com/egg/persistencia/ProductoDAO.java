package com.egg.persistencia;

import com.egg.entidades.Producto;
import java.util.List;

public class ProductoDAO extends DAO {
  
  public List<Producto> listarTodos() throws Exception {
    return em.createQuery("SELECT p FROM Producto p", Producto.class)
      .getResultList();
  }
}
