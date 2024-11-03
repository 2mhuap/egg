package com.egg;

import com.egg.servicios.ClienteServicio;
import com.egg.servicios.EmpleadoServicio;
import com.egg.servicios.GamaProductoServicio;
import com.egg.servicios.OficinaServicio;
import com.egg.servicios.PedidoServicio;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Application {

  public static void main(String[] args) {
    // OficinaServicio oficinaServ = new OficinaServicio();
    // oficinaServ.crearOficina("0FI01", "Mendoza", "Argentina", "Cuyo", "11111111", "CP5000");
    // oficinaServ.listarOficinas();

    // ClienteServicio clienteServ = new ClienteServicio();
    // clienteServ.crearCliente(20, "ClienteA", "NombreA",
    //   "ApellidoA", "1234567890", "1234567890", "Lima",
    //   null, "Peru", "12345", 7, 3000);
    // clienteServ.buscarCliente(3);
    // clienteServ.listarClientesPorCiudad("Madrid");
    
    // GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();
    // gamaProductoServicio.crearGamaProducto("gamaA", "descripcionA", null, null);
    // gamaProductoServicio.buscarGamaProducto(3);
    // gamaProductoServicio.modificarGamaProducto(6, "gamaA", "descripcionAA", null, null);
    // gamaProductoServicio.borrarGamaProducto(6);
    // gamaProductoServicio.listarGamas();

    // EmpleadoServicio eserv = new EmpleadoServicio();
    // eserv.listarEmpleadosPorOficina(2);

    PedidoServicio pServ = new PedidoServicio();
    try {
      Date fechaEntrega = new SimpleDateFormat("yyyy-MM-dd zzzz").parse("2009-01-10 GMT-05:00");
      // System.out.println(fechaEntrega);
      pServ.listarPedidosEntregadosDespues(fechaEntrega);
    } catch (ParseException e) {
      System.out.println("Error fecha");
      e.printStackTrace();
    }


    System.out.println("FIN");
  }
}
