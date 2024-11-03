package POO.Intro.FigurasGeometricas.modelos;

public class Rectangulo {
  private int ancho;
  private int alto;
  public static int contadorRectangulos = 0;

  public Rectangulo(int ancho, int alto){
    this.ancho = ancho;
    this.alto = alto;
    contadorRectangulos++;
  }

  public Rectangulo(){
    contadorRectangulos++;
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

  public int area(){
    return ancho * alto;
  }

  public int perimetro(){
    return 2 * (ancho + alto);
  }

  public void imprimirArea(){
    System.out.println("Area: " + area());
  }

  public void imprimirPerimetro(){
    System.out.println("Perimetro: " + perimetro());
  }

  public static int rectangulosTotal(){
    return contadorRectangulos;
  }

  @Override
  public String toString() {
    return "R(" + ancho + "x" + alto + ")";
  }


}
