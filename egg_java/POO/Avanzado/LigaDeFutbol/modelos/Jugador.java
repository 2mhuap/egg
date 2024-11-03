package POO.Avanzado.LigaDeFutbol.modelos;

public class Jugador {
  private String nombre;
  private Equipo equipo;
  
  public Jugador(String nombre) {
    this.nombre = nombre;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public Equipo getEquipo() {
    return equipo;
  }
  public void setEquipo(Equipo equipo) {
    if (this.equipo != null){
      this.equipo.disminuirContadorJugadores();
    }
    this.equipo = equipo;
    equipo.incrementarContadorJugadores();
  }

  @Override
  public String toString() {
    String str = nombre;
    if (equipo != null){
      str += ", " + equipo.getNombre();
    }
    return str;
  }
  
}
