package POO.Intro.FigurasGeometricas.modelos;

public class Triangulo {
  private int ancho;
  private int alto;
  public static int contadorTriangulos = 0;

  public Triangulo(int ancho, int alto){
    this.ancho = ancho;
    this.alto = alto;
    contadorTriangulos++;
  }

  public Triangulo(){
    contadorTriangulos++;
  }

  public int getAncho(){
    return ancho;
  }

  public void setAncho(int ancho){
    this.ancho = ancho;
  }

  public int getAlto(){
    return alto;
  }

  public void setAlto(int alto){
    this.alto = alto;
  }

  public double area(){
    return ancho * alto * 0.5;
  }

  public void imprimirArea(){
    System.out.println("Area: " + area());
  }

  public static int triangulosTotal(){
    return contadorTriangulos;
  }

  @Override
  public String toString() {
    return "T(" + ancho + "x" + alto + ")";
  }

}
