package POO.Avanzado.Colores.modelos;

public class ConvertidorColor {
  public static Color convertirHexadecimal(String hexadecimal){
    for (Color c: Color.values()){
      if (c.getValorHexadecimal().equals(hexadecimal)){
        return c;
      }
    }

    return null;
  }
}
