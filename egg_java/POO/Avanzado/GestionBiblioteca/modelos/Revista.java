package POO.Avanzado.GestionBiblioteca.modelos;

import java.time.LocalDate;

public class Revista extends ItemBiblioteca implements Catalogable {
  private String nombreRevista;
  private int nroEdicion;
  private int cantidadEjemplares;
  
  public Revista(String nombreRevista, int nroEdicion, int cantidadEjemplares, double multaPorDia) {
    super(multaPorDia);
    this.nombreRevista = nombreRevista;
    this.nroEdicion = nroEdicion;
    this.cantidadEjemplares = cantidadEjemplares;
  }

  @Override
  public boolean prestar(){
    if (cantidadEjemplares > 0){
      cantidadEjemplares--;
      System.out.println("Revista prestada.");
      return true;
    }

    System.out.println("No se puede prestar - no hay ejemplar disponible.");
    return false;
  }

  public void devolver(){
    cantidadEjemplares++;
  }

  @Override
  public void obtenerInformacion() {
    System.out.println("Nombre: " + nombreRevista);
    System.out.println("Número de edición: " + nroEdicion);
    System.out.println("Cantidad de ejemplares: " + cantidadEjemplares);
  }

  @Override
  public double calcularMulta() {
    LocalDate dev = LocalDate.now();
    LocalDate venci = LocalDate.now().minusDays(5);
    return calcularDiasRetraso(dev, venci) * getMultaPorDia();
  }
  
}
