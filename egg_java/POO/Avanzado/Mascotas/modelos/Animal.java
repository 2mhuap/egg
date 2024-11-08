package POO.Avanzado.Mascotas.modelos;

public class Animal {
  private String nombre;
  private int edad;

  public Animal(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public int getEdad() {
    return edad;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void comer() {
    System.out.println("El animal está comiendo.");
  }

  public void dormir() {
    System.out.println("El animal está durmiendo.");
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + edad;
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Animal other = (Animal) obj;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (edad != other.edad)
      return false;
    return true;
  }

}
