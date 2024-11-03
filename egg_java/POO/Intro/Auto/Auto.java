package POO.Intro.Auto;

public class Auto {
  private String marca;
  private String modelo;
  private int anho;

  public Auto(String marca, String modelo, int anho){
    this.marca = marca;
    this.modelo = modelo;
    this.anho = anho;
  }

  public Auto(String marca, String modelo){
    this.marca = marca;
    this.modelo = modelo;
  }

  public Auto(String marca){
    this.marca = marca;
  }

  public Auto(){

  }

  public void imprimirDatos() {
    if (marca != null){
      System.out.println("Marca: " + marca);
    }
    if (modelo != null){
      System.out.println("Modelo: " + modelo);
    }
    if (anho != 0){
      System.out.println("Año: " + anho);
    }

    if (marca == null && modelo == null && anho == 0){
      System.out.println("El Auto fue inicializado sin parametros.");
    }
    
  }

}
