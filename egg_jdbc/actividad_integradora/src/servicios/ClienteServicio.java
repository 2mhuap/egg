package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
  private ClienteDAO dao;
  
  public ClienteServicio(){
    this.dao = new ClienteDAO();
  }

  public Cliente crearCliente(
    String nombre,
    String calle,
    int numero,
    String codigoPostal,
    String ciudad,
    String pais,
    String email
  ) {
    Cliente cliente = new Cliente(nombre, calle, numero, codigoPostal, ciudad, pais, email);
    dao.insertar(cliente);
    return cliente;
  }

  public void listarClientes(){
    for (Cliente cliente : dao.getTodos()){
      System.out.println(cliente);
    }
  }

  public void buscarCliente(int id){
    System.out.println(dao.getPorId(id));
  }

  public void eliminarCliente(int id){
    dao.eliminarPorId(id);
  }

  public Cliente modificarCliente(
    int id,
    String nombre,
    String calle,
    int numero,
    String codigoPostal,
    String ciudad,
    String pais,
    String email
  ){
    Cliente cliente = new Cliente(id, nombre, calle, numero, codigoPostal, ciudad, pais, email);
    dao.update(cliente);
    return cliente;
  }
}
