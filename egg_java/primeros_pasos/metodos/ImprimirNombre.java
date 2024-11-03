package metodos;

import java.util.Scanner;

public class ImprimirNombre {

  public static Scanner pepe = new Scanner(System.in);
  public static void main(String[] args) {
    String nombre = obtenerNombre();
    int edad = obtenerEdad();
    imprimirNombreYEdad(nombre, edad);
    pepe.close();
  }

  public static String obtenerNombre() {
    System.out.println("Por favor ingrese un nombre:");
    return pepe.nextLine();
  }

  public static int obtenerEdad() {
    System.out.println("Por favor ingrese una edad:");
    return pepe.nextInt();
  }

  public static void imprimirNombreYEdad(String nombre, int edad) {
    System.out.println("Nombre: " + nombre);
    System.out.println("Edad: " + edad);
  }

}
