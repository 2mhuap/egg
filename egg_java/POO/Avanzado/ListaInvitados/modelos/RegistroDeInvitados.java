package POO.Avanzado.ListaInvitados.modelos;

import java.util.HashSet;

public class RegistroDeInvitados {
  private HashSet<String> invitados;


  public RegistroDeInvitados() {
    invitados = new HashSet<String>();
  }

  public void agregarInvitado(String nombre) {
    if (invitados.contains(nombre)){
      System.out.println("Ese nombre ya está en la lista de invitados.");
    } else {
      invitados.add(nombre);
    }
    
  }

  public void eliminarInvitado(String nombre) {
    invitados.remove(nombre);
  }
  
  public void mostrarInvitados(){
    System.out.println("Invitados:");
    System.out.println(invitados.toString());
  }
}
