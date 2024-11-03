package POO.Avanzado.Colores;

import POO.Avanzado.Colores.modelos.Color;
import POO.Avanzado.Colores.modelos.ConvertidorColor;

public class Application {
  public static void main(String[] args) {
    String[] hex = {"#FF0000", "#FFFFFF", "#252525", "#0000FF", "#4E4D5C"};
    for (String h : hex) {
      System.out.print(h + ": ");
      Color c = ConvertidorColor.convertirHexadecimal(h);
      if (c != null){
        System.out.println(c);
      } else {
        System.out.println("No es un color primario.");
      }
    }
  }
}
