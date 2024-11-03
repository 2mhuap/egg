package POO.Intro.Rectangulo;

public class Rectangulo {
  int ancho;
  int alto;
  static int contadorRectangulos = 0;

  public Rectangulo(int ancho, int alto){
    this.ancho = ancho;
    this.alto = alto;
    contadorRectangulos++;
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
    return ancho + "x" + alto;
  }


}
