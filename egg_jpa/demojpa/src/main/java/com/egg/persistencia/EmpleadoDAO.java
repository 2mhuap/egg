package com.egg.persistencia;

import com.egg.entidades.Empleado;
import java.util.List;

public class EmpleadoDAO extends DAO {
  public List<Empleado> listarTodos() throws Exception {
    return em.createQuery("SELECT e FROM Empleado e", Empleado.class)
      .getResultList();
  }

  public List<Empleado> listarEmpleadosPorOficina(int idOficina) throws Exception {
    return em.createQuery("SELECT e FROM Empleado e WHERE e.oficina.idOficina = :oficina", Empleado.class)
      .setParameter("oficina", idOficina)
      .getResultList();
  }
}
