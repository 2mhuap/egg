package actividad_integradora_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionContrasena {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una contraseña: ");
    String contra = miScanner.nextLine();

    Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,}$");
    Matcher m = p.matcher(contra);
    boolean b = m.matches();

    if (b) {
      System.out.println("¡Contraseña segura! Cumple con todos los criterios.");
    } else {
      System.out.println("Contraseña no segura.");
    }
    
    miScanner.close();
  }
}