package POO.Avanzado.GestionCodigosPostales;

import java.util.HashMap;

public class Application {
  private static HashMap<String, String> codigosPostales = new HashMap<>();

  public static void main(String[] args) {
    codigosPostales.put("12487", "Berlin");
    codigosPostales.put("100208", "Otavalo");
    codigosPostales.put("H0M 0A1", "Belfast");

    System.out.println(codigosPostales.toString());

    if (codigosPostales.containsKey("12487")){
      System.out.println(codigosPostales.get("12487"));
    }

    codigosPostales.remove("H0M 0A1");
    System.out.println(codigosPostales.toString());
  }
}
