package com.egg.persistencia;

import com.egg.entidades.Cliente;

import java.util.List;

public class ClienteDAO extends DAO {
  
  public void guardaCliente(Cliente cliente) throws Exception {
    em.getTransaction().begin();
    em.persist(cliente);
    em.getTransaction().commit();
  }

  public Cliente buscarCliente(int id) throws Exception {
    Cliente c = em.find(Cliente.class, id);
    return c;
  }

  public List<Cliente> listarTodos() throws Exception {
    return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
      .getResultList();
  }

  public List<Cliente> listarClientesPorNombre(String nombre) throws Exception {
    return em.createQuery("SELECT c FROM Cliente c WHERE c.nombreContacto LIKE :nombre", Cliente.class)
      .setParameter("nombre", "%" + nombre + "%")
      .getResultList();
  }

  public List<Cliente> listarClientesPorCiudad(String ciudad) throws Exception {
    return em.createQuery("SELECT c FROM Cliente c WHERE c.ciudad LIKE :ciudad", Cliente.class)
      .setParameter("ciudad", "%" + ciudad + "%")
      .getResultList();
  }
}
