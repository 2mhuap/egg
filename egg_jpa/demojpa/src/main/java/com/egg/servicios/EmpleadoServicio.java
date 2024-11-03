package com.egg.servicios;

import com.egg.persistencia.EmpleadoDAO;
import com.egg.entidades.Empleado;
import java.util.List;

public class EmpleadoServicio {
  private final EmpleadoDAO dao;

  public EmpleadoServicio(){
    this.dao = new EmpleadoDAO();
  }

  public void listarEmpleados() {
    try {
      List<Empleado> todos = dao.listarTodos();
      imprimirLista(todos);
    } catch (Exception e) {
      System.out.println("Error listando empleados");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void listarEmpleadosPorOficina(int idOficina) {
    try {
      List<Empleado> empleadosOficina = dao.listarEmpleadosPorOficina(idOficina);
      imprimirLista(empleadosOficina);
    } catch (Exception e) {
      System.out.println("Error listando empleados oficina=" + idOficina);
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  private void imprimirLista(List<Empleado> lista) {
    for (Empleado e : lista) {
      System.out.println(e.getCodigoEmpleado() + " | " + e.getNombre()
        + " | " + e.getApellido() + " | " + e.getOficina());
    }
  }
}
