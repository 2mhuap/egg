package POO.Intro.FigurasGeometricas.modelos;

public class Circulo {
  private int radio;
  public static int contadorCirculos = 0;

  public Circulo(int radio){
    this.radio = radio;
    contadorCirculos++;
  }

  public Circulo(){
    contadorCirculos++;
  }

  public int getRadio(){
    return radio;
  }

  public void setRadio(int radio){
    this.radio = radio;
  }

  public double area(){
    return Math.PI * radio * radio;
  }

  public double perimetro(){
    return 2 * Math.PI * radio;
  }

  public void imprimirArea(){
    System.out.println("Area: " + area());
  }

  public void imprimirPerimetro(){
    System.out.println("Perimetro: " + perimetro());
  }

  public static int rectangulosTotal(){
    return contadorCirculos;
  }

  @Override
  public String toString() {
    return "C(" + radio + ")";
  }


}
