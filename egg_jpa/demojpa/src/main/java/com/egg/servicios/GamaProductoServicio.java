package com.egg.servicios;

import java.util.List;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
  private final GamaProductoDAO dao;

  public GamaProductoServicio(){
    this.dao = new GamaProductoDAO();
  }

  public void crearGamaProducto(
    String gama,
    String descripcionTexto,
    String descripcionHtml,
    String imagen
  ) {
    try {
      GamaProducto g = new GamaProducto();
      g.setGama(gama);
      g.setDescripcionTexto(descripcionTexto);
      g.setDescripcionHtml(descripcionHtml);
      g.setImagen(imagen);

      dao.guardaGamaProducto(g);
    } catch (Exception e) {
      System.out.println("Error guardando gama producto");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void buscarGamaProducto(int id){
    try {
      GamaProducto g = dao.buscarGamaProducto(id);
      if (g != null){
        System.out.println(g.getIdGama() + " | " + g.getGama());
      } else {
        System.out.println("GamaProducto no fue encontrado");
      }
    } catch (Exception e) {
      System.out.println("Error buscando gama producto");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void modificarGamaProducto(
    int idGama,
    String gama,
    String descripcionTexto,
    String descripcionHtml,
    String imagen
  ) {
    try {
      GamaProducto g = new GamaProducto();
      g.setIdGama(idGama);
      g.setGama(gama);
      g.setDescripcionTexto(descripcionTexto);
      g.setDescripcionHtml(descripcionHtml);
      g.setImagen(imagen);

      dao.modificarGamaProducto(g);
    } catch (Exception e) {
      System.out.println("Error modificando gama producto");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void borrarGamaProducto(int id){
    try {
      dao.borrarGamaProducto(id);
    } catch (Exception e) {
      System.out.println("Error borrando gama producto");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void listarGamas() {
    try {
      List<GamaProducto> todas = dao.listarTodas();
      imprimirLista(todas);
    } catch (Exception e) {
      System.out.println("Error listando gamas");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  private void imprimirLista(List<GamaProducto> lista) {
    for (GamaProducto g : lista) {
      System.out.println(g.getIdGama() + " | " + g.getGama());
    }
  }
}
