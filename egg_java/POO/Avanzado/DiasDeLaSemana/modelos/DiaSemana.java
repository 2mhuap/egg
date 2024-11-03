package POO.Avanzado.DiasDeLaSemana.modelos;

public enum DiaSemana {
  LUNES, MARTES, MIÉRCOLES, JUEVES, VIERNES, SÁBADO, DOMINGO;

  public boolean esDiaLaboral() {
    boolean resultado;
    switch(this){
      case SÁBADO, DOMINGO -> resultado = false;
      default -> resultado = true;
    }
    return resultado;
  }

}
