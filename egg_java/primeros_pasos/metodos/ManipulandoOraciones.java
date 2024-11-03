package metodos;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManipulandoOraciones {
  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    String oracion = "";
    String[] palabras = new String[0];
    boolean salir = false;
    while (!salir) {
      imprimirMenu(oracion);
      System.out.print("Elije una opción: ");
      int op = sc.nextInt();

      try {
        switch (op) {
          case 1 -> {
            oracion = crearBorrar(oracion);
            palabras = oracion.split(" ");
          }
          case 2 -> cantidadCaracteres(oracion);
          case 3 -> cantidadPalabras(palabras);
          case 4 -> palabrasOrdenadas(oracion);
          case 5 -> numeroPalabra(palabras);
          case 6 -> buscarPalabra(palabras);
          case 7 -> {
            oracion = modificarPalabra(oracion, palabras);
            palabras = oracion.split(" ");
          }
          case 8 -> {
            oracion = agregarContenido(oracion);
            palabras = oracion.split(" ");
          }
          case 9 -> salir = true;
          default -> System.out.println("Opción inválida.");
        };
      } catch (InputMismatchException e) {
        System.out.println("Elije opción con su número.");
      }
      
    }
    sc.close();
  }

  public static void imprimirMenu(String oracion) {
    System.out.println("Menu:");
    if (oracion.length() == 0){
      System.out.println("1. Crear oración");
    } else {
      System.out.println("1. Borrar oración");
    }
    System.out.println("""
        2. Cantidad de caracteres de la oración
        3. Cantidad de palabras de la oración
        4. Mostrar palabras ordenadas alfabéticamente
        5. Ingresar un número y devolver la palabra correspondiente
        6. Buscar palabra dentro de la oración
        7. Modificar palabra dentro de la oración
        8. Agregar contenido a la oración
        9. Salir""");
  }

  public static String crearBorrar(String oracion){
    if (oracion.length() == 0){
      System.out.print("Ingrese la oración: ");
      sc.nextLine();
      oracion = sc.nextLine();
      System.out.println("Oración creada");
    } else {
      oracion = "";
      System.out.println("Oración borrada");
    }

    return oracion;
  }

  public static void cantidadCaracteres(String oracion) {
    System.out.println("Cantidad de caracteres: " + oracion.length());
  }

  public static void cantidadPalabras(String[] palabras) {
    System.out.println("Cantidad de palabras: " + palabras.length);
  }

  public static void palabrasOrdenadas(String oracion) {
    String[] palabrasOrd = oracion.split(" ");
    Arrays.sort(palabrasOrd);
    System.out.println("Palabras ordenadas alfabéticamente: ");
    System.out.println(Arrays.toString(palabrasOrd));
  }

  public static void numeroPalabra(String[] palabras){
    boolean salir5 = true;
    do {
      System.out.println("Ingrese número para mostrar la palabra correspondiente: ");
      int pNum = sc.nextInt();
      try {
        System.out.println("La palabra es: " + palabras[pNum - 1]);
        salir5 = true;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Número inválido. Intente nuevamente.");
        salir5 = false;
      }
    } while (!salir5);
  }

  public static void buscarPalabra(String[] palabras){
    System.out.print("Ingrese palabra para buscar: ");
    sc.nextLine();
    String buscar = sc.nextLine();
    
    boolean encontrada = false;
    int i = 0;
    while (!encontrada && i < palabras.length){
      if (buscar.equals(palabras[i])){
        System.out.println("La palabra fue encontrada en la posición " + i);
        encontrada = true;
      }
      i++;
    }

    if (!encontrada){
      System.out.println("La palabra NO fue encontrada.");
    }
  }

  public static String modificarPalabra(String oracion, String[] palabras){
    boolean encontrada7 = false;
    do {
      System.out.print("Ingrese la palabra que quiere cambiar: ");
      sc.nextLine();
      String cambiar = sc.nextLine();
      for (String pal : palabras) {
        if (pal.equals(cambiar)){
          encontrada7 = true;
          System.out.print("Ingrese una nueva palabra: ");
          String nueva = sc.nextLine();
          oracion = oracion.replaceAll(cambiar, nueva);
          System.out.println("Nueva oración: " + oracion);
          return oracion;
        }
      }

      if (!encontrada7){
        System.out.println("La palabra NO fue encontrada.");
      }

    } while (!encontrada7);

    return oracion;
  }

  public static String agregarContenido(String oracion) {
    System.out.print("Ingrese contenido para agregar: ");
    sc.nextLine();
    oracion = oracion.concat(sc.nextLine());
    System.out.println("Nueva oración: " + oracion);
    return oracion;
  }


}

