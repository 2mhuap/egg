package POO.Avanzado.GeometriaAbstracta.modelos;

public class Circulo extends Figura implements Dibujable{
  private double radio;

  public Circulo(double radio) {
    this.radio = radio;
  }

  @Override
  public double calcularArea() {
    return Math.PI * radio * radio;
  }

  @Override
  public double calcularPerimetro() {
    return Math.PI * radio * 2;
  }

  @Override
  public void dibujar() {
    int radio = 5;
    for (int i = -radio; i <= radio; i++) {
      for (int j = -radio; j <= radio; j++) {
        if (i * i + j * j <= radio * radio) {
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
  
}
