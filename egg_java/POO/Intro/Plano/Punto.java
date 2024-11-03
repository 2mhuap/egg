package POO.Intro.Plano;

public class Punto {
  private double x;
  private double y;

  // public Punto(double x, double y){
  //   this.x = x;
  //   this.y = y;
  // }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double distanciaDesdeOrigen() {
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
  }

  public static double calcularDistancia(Punto p1, Punto p2){
    double parteX = Math.pow(p2.getX() - p1.getX(), 2);
    double parteY = Math.pow(p2.getY() - p1.getY(), 2);
    return Math.sqrt(parteX + parteY);
  }

  public static boolean estanAlineados(Punto p1, Punto p2, Punto p3) {
    double p1p2 = calcularDistancia(p1, p2);
    double p1p3 = calcularDistancia(p1, p3);
    double p2p3 = calcularDistancia(p2, p3);

    boolean suma1 = p1p2 + p1p3 == p2p3;
    boolean suma2 = p1p2 + p2p3 == p1p3;
    boolean suma3 = p1p3 + p2p3 == p1p2;

    return suma1 || suma2 || suma3;
    
  }
}
