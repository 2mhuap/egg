package bucles;

import java.util.Scanner;

/**
 * MenuInteractivo
 */
public class ValidacionContrasena {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String contra = "secreto1234";
    boolean correcto = false;
    while(!correcto){
      System.out.print("Ingrese su contraseña: ");
      String intento = sc.nextLine();
      if (intento.equals(contra)){
        correcto = true;
      } else {
        System.out.println("Incorrecto. Intente otra vez.");
      }
    }
    System.out.println("Correcto");
    sc.close();
  }
}