package POO.Avanzado.GeometriaAbstracta.modelos;

public class Triangulo extends Figura implements Dibujable{
  private double lado1;
  private double lado2;
  private double lado3;

  public Triangulo(double lado1, double lado2, double lado3) {
    this.lado1 = lado1;
    this.lado2 = lado2;
    this.lado3 = lado3;
  }

  @Override
  public double calcularArea() {
    double s = (lado1 + lado2 + lado3) / 2;
    return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
  }

  @Override
  public double calcularPerimetro() {
    return lado1 + lado2 + lado3;
  }

  @Override
  public void dibujar() {
    for (int i = 0; i < lado1; i++) {
      for (int j = 0; j < i + 1; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }


  
}
