package actividad_integradora_5;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManipulandoOraciones {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    String oracion = "";
    String[] palabras = new String[0];
    boolean salir = false;
    while (!salir) {
      imprimirMenu(oracion);
      System.out.print("Elije una opción: ");
      int op = sc.nextInt();

      try {
        switch (op) {
          case 1:
            // crear o borrar
            if (oracion.length() == 0){
              System.out.print("Ingrese la oración: ");
              sc.nextLine();
              oracion = sc.nextLine();
              palabras = oracion.split(" ");
              System.out.println("Oración creada");
            } else {
              oracion = "";
              System.out.println("Oración borrada");
            }
            break;
          case 2:
            // cantidad caracteres
            System.out.println("Cantidad de caracteres: " + oracion.length());
            break;
          case 3:
            // cantidad palabras
            System.out.println("Cantidad de palabras: " + palabras.length);
            break;
          case 4:
            // palabras ordenadas
            String[] palabrasOrd = oracion.split(" ");
            Arrays.sort(palabrasOrd);
            System.out.println("Palabras ordenadas alfabéticamente: ");
            System.out.println(Arrays.toString(palabrasOrd));
            break;
          case 5:
            // numero -> palabra
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
            
            break;
          case 6:
            // buscar palabra
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
            break;
          case 7:
            // replace

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
                  palabras = oracion.split(" ");
                  System.out.println("Nueva oración: " + oracion);
                }
              }

              if (!encontrada7){
                System.out.println("La palabra NO fue encontrada.");
              }

            } while (!encontrada7);

            
            break;
          case 8:
            // agregar contenido
            System.out.print("Ingrese contenido para agregar: ");
            sc.nextLine();
            oracion = oracion.concat(sc.nextLine());
            palabras = oracion.split(" ");
            System.out.println("Nueva oración: " + oracion);
            break;
          case 9:
            // salir
            salir = true;
            break;
          default:
            System.out.println("Opción inválida.");
            break;
        };
      } catch (InputMismatchException e) {
        System.out.println("Elije opción con su número.");
      }
      
    }
    sc.close();
  }

  static void imprimirMenu(String oracion) {
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
}
