package POO.Avanzado.GeometriaAbstracta;

import POO.Avanzado.GeometriaAbstracta.modelos.Circulo;
import POO.Avanzado.GeometriaAbstracta.modelos.Rectangulo;
import POO.Avanzado.GeometriaAbstracta.modelos.Triangulo;

public class Application {
  public static void main(String[] args) {
    Rectangulo r = new Rectangulo(5,  6);
    // r.dibujar();
    Triangulo t = new Triangulo(4, 6, 6);
    // t.dibujar();
    Circulo c = new Circulo(10);
    c.dibujar();
  }
}
