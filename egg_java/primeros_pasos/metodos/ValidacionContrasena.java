package metodos;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionContrasena {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese una contraseña: ");
    String contra = sc.nextLine();

    if (esSegura(contra)) {
      System.out.println("¡Contraseña segura! Cumple con todos los criterios.");
    } else {
      System.out.println("Contraseña no segura.");
    }
    
    sc.close();
  }

  public static boolean esSegura(String contrasenha) {
    Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,}$");
    Matcher m = p.matcher(contrasenha);
    boolean b = m.matches();
    return b;
  }
}