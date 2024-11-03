package POO.Avanzado.Mascotas;

import POO.Avanzado.Mascotas.modelos.Animal;
import POO.Avanzado.Mascotas.modelos.Gato;
import POO.Avanzado.Mascotas.modelos.Perro;

public class Application {
  public static void main(String[] args) {
    Gato gato1 = new Gato("Luna", 4);
    Gato gato2 = new Gato("Luna", 4);
    Gato gato3 = new Gato("Luis", 3);
    Gato gato4 = new Gato("Tom", 1);
    Gato gato5 = new Gato("Garfield", 4);
    Perro perro1 = new Perro("Oscar", 2);
    Perro perro2 = new Perro("Oscar", 2);
    Perro perro3 = new Perro("Oscar", 3);
    Perro perro4 = new Perro("Bruno", 2);
    Perro perro5 = new Perro("Oscar", 5);
    
    // gato1.comer();
    // perro2.dormir();
    
    // System.out.println(perro1.equals(perro2));
    // System.out.println(perro1.equals(perro3));

    // System.out.println(gato1.equals(gato2));
    // System.out.println(gato1.equals(gato3));
    Animal[] animales = {gato1, perro3, gato2, perro2, gato5, perro5, gato3, perro1, gato4, perro4};
    for (Animal a : animales) {
      if (a instanceof Gato){
        System.out.println("Gato");
        ((Gato)a).maullar();
        a.comer();
      } else if (a instanceof Perro){
        System.err.println("Perro");
        ((Perro)a).ladrar();
        a.dormir();
      }
    }

  }
}
