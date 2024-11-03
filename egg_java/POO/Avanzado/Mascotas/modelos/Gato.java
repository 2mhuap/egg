package POO.Avanzado.Mascotas.modelos;

public class Gato extends Animal {

  public Gato(String nombre, int edad) {
    super(nombre, edad);
  }

  public void maullar(){
    System.out.println("El gato está maullando.");
  }

  @Override
  public void comer() {
    System.out.println("El gato está comiendo paté.");
  }

  @Override
  public void dormir() {
    System.out.println("El gato está durmiendo en el sofá.");
  }
   
}
