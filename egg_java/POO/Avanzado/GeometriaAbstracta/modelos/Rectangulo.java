package POO.Avanzado.GeometriaAbstracta.modelos;

public class Rectangulo extends Figura implements Dibujable {
  private double alto;
  private double ancho;

  public Rectangulo(double alto, double ancho) {
    this.alto = alto;
    this.ancho = ancho;
  }

  @Override
  public double calcularArea() {
    return alto * ancho;
  }

  @Override
  public double calcularPerimetro() {
    return 2 * (alto + ancho);
  }

  @Override
  public void dibujar() {
    for (int i = 0; i < alto; i++) {
      for (int j = 0; j < ancho; j++) {
        if (i == 0 || i == alto - 1 || j == 0 || j == ancho - 1){
          // borde arriba o abajo
          System.out.print("* ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.print("\n");
    }
  }
  
}
