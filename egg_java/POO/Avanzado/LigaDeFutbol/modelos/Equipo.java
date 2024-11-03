package POO.Avanzado.LigaDeFutbol.modelos;

public class Equipo {
  private String nombre;
  private int contadorJugadores = 0;

  public Equipo(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void imprimirDetalles(){
    String str = "Equipo --------\n  " + nombre;
    System.out.println(str);
  }

  public void incrementarContadorJugadores(){
    contadorJugadores++;
  }

  public void disminuirContadorJugadores(){
    contadorJugadores--;
  }

  public int getContadorJugadores() {
    return contadorJugadores;
  }
  
}
