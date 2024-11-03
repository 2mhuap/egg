package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;

public class OficinaServicio {
  private final OficinaDAO dao;

  public OficinaServicio(){
    this.dao = new OficinaDAO();
  }

  public void crearOficina(String codigoOficina, String ciudad, String pais,
      String region, String codigoPostal, String telefono) {
    try {
      Oficina nueva = new Oficina();
      nueva.setCodigoOficina(codigoOficina);
      nueva.setCiudad(ciudad);
      nueva.setPais(pais);
      nueva.setRegion(region);
      nueva.setCodigoPostal(codigoPostal);
      nueva.setTelefono(telefono);

      dao.guardaOficina(nueva);
    } catch (Exception e) {
      System.out.println("Error guardando oficina");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void listarOficinas() {
    try {
      List<Oficina> todas = dao.listarTodas();
      imprimirLista(todas);
    } catch (Exception e) {
      System.out.println("Error listando oficinas");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  private void imprimirLista(List<Oficina> lista) {
    for (Oficina o : lista){
      System.out.println(o.getCodigoOficina() + " | "
        + o.getCiudad() + " | " + o.getPais());
    }
  }

}
