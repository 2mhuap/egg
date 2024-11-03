package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

public class ClienteServicio {
  private final ClienteDAO dao;

  public ClienteServicio(){
    this.dao = new ClienteDAO();
  }

  public void crearCliente(int codigoCliente, String nombreCliente, String nombreContacto,
      String apellidoContacto, String telefono, String fax, String ciudad, String region,
      String pais, String codigoPostal, int idEmpleado, double limiteCredito){
    try {
      Cliente c = new Cliente();
      c.setCodigoCliente(codigoCliente);
      c.setNombreCliente(nombreCliente);
      c.setNombreContacto(nombreContacto);
      c.setApellidoContacto(apellidoContacto);
      c.setTelefono(telefono);
      c.setFax(fax);
      c.setCiudad(ciudad);
      c.setRegion(region);
      c.setPais(pais);
      c.setCodigoPostal(codigoPostal);
      c.setIdEmpleado(idEmpleado);
      c.setLimiteCredito(limiteCredito);

      dao.guardaCliente(c);
    } catch (Exception e) {
      System.out.println("Error guardando cliente");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void buscarCliente(int id){
    try {
      Cliente c = dao.buscarCliente(id);
      if (c != null){
        System.out.println(c.getIdCliente() + " | " + c.getNombreCliente());
      } else {
        System.out.println("Cliente no fue encontrado");
      }
    } catch (Exception e) {
      System.out.println("Error buscando cliente");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void listarClientes() {
    try {
      List<Cliente> todos = dao.listarTodos();
      imprimirLista(todos);
    } catch (Exception e) {
      System.out.println("Error listando clientes");
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void listarClientesPorNombre(String nombre) {
    try {
      List<Cliente> conNombre = dao.listarClientesPorNombre(nombre);
      imprimirLista(conNombre);
    } catch (Exception e) {
      System.out.println("Error listando clientes nombre=" + nombre);
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  public void listarClientesPorCiudad(String ciudad) {
    try {
      List<Cliente> clientesCiudad = dao.listarClientesPorCiudad(ciudad);
      imprimirLista(clientesCiudad);
    } catch (Exception e) {
      System.out.println("Error listando clientes ciudad=" + ciudad);
      System.out.println(e.getMessage());
    } finally {
      dao.cerrar();
    }
  }

  private void imprimirLista(List<Cliente> lista) {
    for (Cliente c : lista) {
      System.out.println(c.getCodigoCliente() + " | " + c.getNombreCliente());
    }
  }

}
