package POO.Avanzado.GestionBiblioteca.modelos;

import java.time.LocalDate;
import java.time.Period;

public abstract class ItemBiblioteca {
  private double multaPorDia;

  public ItemBiblioteca(double multaPorDia) {
    this.multaPorDia = multaPorDia;
  }

  public static int calcularDiasRetraso(LocalDate devolucion, LocalDate vencimiento){
    if (devolucion.isAfter(vencimiento)){
      Period p = vencimiento.until(devolucion);
      return p.getDays();
    }
    return 0;
  }

  public abstract boolean prestar();
  public abstract void devolver();

  public abstract double calcularMulta();

  public double getMultaPorDia() {
    return multaPorDia;
  }

  public void setMultaPorDia(double multaPorDia) {
    this.multaPorDia = multaPorDia;
  }

  
}
