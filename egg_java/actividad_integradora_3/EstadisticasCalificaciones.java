package actividad_integradora_3;

public class EstadisticasCalificaciones {
  public static void main(String[] args) {
    int min = 0;
    int max = 10;

    int length = 8;
    String[] calArr = new String[length];
    for (int i = 0; i < length; i++) {
      int cal = (int)(Math.random() * (max - min + 1)) + min;
      calArr[i] = Integer.toString(cal);
    }

    int[] desaprobados = new int[8];
    int desIdx = 0;
    int[] aprobado = new int[8];
    int aprIdx = 0;
    int[] excelente = new int[8];
    int excIdx = 0;

    for (String cal : calArr) {
      int calInt = Integer.parseInt(cal);
      if (calInt < 4){
        desaprobados[desIdx] = calInt;
        desIdx++;
      } else if (calInt >= 10){
        excelente[excIdx] = calInt;
        excIdx++;
      } else {
        aprobado[aprIdx] = calInt;
        aprIdx++;
      }
    }

    

  }
}
