package POO.Avanzado.DiasDeLaSemana;

import POO.Avanzado.DiasDeLaSemana.modelos.DiaSemana;

public class Application {
  public static void main(String[] args) {
    DiaSemana[] dias = DiaSemana.values();

    DiaSemana[] aleatorio = new DiaSemana[10];

    for (int i = 0; i < aleatorio.length; i++) {
      int num = numeroAleatorio(0, 6);
      DiaSemana d = dias[num];
      
      aleatorio[i] = d;
      // aleatorio[i] = dias[num];
    }

    for (DiaSemana d : aleatorio) {
      System.out.print(d + ": ");
      imprimirDiaLaboral(d);
    }

  }

  private static int numeroAleatorio(int min, int max){
    return (int)(Math.random() * (max - min + 1)) + min; 
  }

  private static void imprimirDiaLaboral(DiaSemana dia){
    if (dia.esDiaLaboral()){
      System.out.println("Si es día laboral.");
    } else {
      System.out.println("No es día laboral.");
    }
  }
}
