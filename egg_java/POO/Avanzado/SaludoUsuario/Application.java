package POO.Avanzado.SaludoUsuario;

import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    String nombre = solicitarNombre();
    System.out.println(nombre);
  }

  private static String solicitarNombre() {
    try (Scanner sc = new Scanner(System.in)){
      System.out.print("Ingrese su nombre: ");
      String nombre = sc.nextLine();
      if (nombre.length() < 2){
        throw new Exception("Nombre tiene menos de 2 caracteres.");
      }
      return nombre;
    } catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
    return null;
  }

  
}
