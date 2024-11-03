package POO.Avanzado.ListaCiudades;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    ArrayList<String> ciudades = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);
    boolean salir = false;
    while (!salir){
      System.out.print("Ingrese el nombre de una ciudad o 0 para salir: ");
      String ciudad = sc.nextLine();
      if (ciudad.equals("0")){
        salir = true;
      } else {
        ciudades.add(ciudad);
      }
    }

    System.out.println(ciudades.toString());
    sc.close();
  }
}
