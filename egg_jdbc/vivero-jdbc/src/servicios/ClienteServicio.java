package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class ClienteServicio {
  private ClienteDAO cd;

  public ClienteServicio(){
    this.cd = new ClienteDAO();
  }

  public Cliente crearNuevoCliente(int codigoC, String nombre, String nombreContacto, String apellidoContacto,
    String telefono, String fax, String ciudad, String region, String pais, String codigoPostal,
    int idEmpleado, double limiteCredito) throws Exception {

    validacionesNyA(nombreContacto, apellidoContacto);
    Cliente cliente = new Cliente(codigoC, nombre, nombreContacto, apellidoContacto, telefono, fax, ciudad, region,
      pais, codigoPostal, idEmpleado, limiteCredito);
    cd.guardarCliente(cliente);
    return cliente;
  }

  public void validacionesNyA(String nombreContacto, String apellidoContacto) throws Exception{
    if (nombreContacto == null) {
        throw new Exception("El nombre del contacto no puede ser nulo.");
    }
    if (apellidoContacto == null) {
        throw new Exception("El apellido del contacto no puede ser nulo.");
    }
  }

  public void listarClientes() {
    cd.listarTodosLosClientes();
  }

  public void buscarCliente(int codigo) throws Exception {
    if (codigo < 1) {
      throw new Exception("El codigo del cliente es inválido.");
    }

    Cliente c = cd.buscarClientePorCodigo(codigo);
    if (c != null){
      System.out.println(c);
    } else {
      System.out.println("El cliente no fue encontrado.");
    }
  }
}
