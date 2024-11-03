package actividad_integradora_6;

import java.util.Arrays;
import java.util.Scanner;

public class RegistroAlumnos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int maxAlumnos = 20;
    String[] alumnos = new String[maxAlumnos];
    int cantidad = 0;
    double[] notas = new double[maxAlumnos];
    Arrays.fill(notas, -1);

    boolean salir = false;
    while(!salir){
      System.out.println("""
          Menu:
          1. Registrar alumno
          2. Mostrar todos los alumnos
          3. Mostrar promedio de notas
          4. Buscar alumno por nombre
          5. Modificar nota por nombre
          6. Eliminar alumno por nombre
          7. Salir""");
      System.out.print("Elije una opción: ");
      int op = sc.nextInt();
      sc.nextLine();
      switch (op) {
        case 1:
          // registrar
          if (cantidad < 20){
            System.out.print("Ingrese el nombre del nuevo alumno: ");
            String nombre1 = sc.nextLine();
            System.out.print("Ingrese la nota: ");
            double nota = sc.nextDouble();
            sc.nextLine();
            if (nota < 0 || nota > 10){
              System.out.println("Nota inválida");
            } else {
              int i1 = 0;
              boolean guardado = false;
              while(i1 < maxAlumnos && !guardado){
                if (alumnos[i1] == null) {
                  alumnos[i1] = nombre1;
                  notas[i1] = nota;
                  cantidad++;
                  guardado = true;
                }
                i1++;
              }
            }
          } else {
            System.out.println("No hay espacio.");
          }
          
          break;
        case 2:
          // mostrar todos
          if (cantidad != 0) {
            for (int i = 0; i < maxAlumnos; i++) {
              if (alumnos[i] != null){
                System.out.println(alumnos[i] + ": " + notas[i]);
              }
            }
          } else {
            System.out.println("No hay alumnos");
          }
          break;
        case 3:
          // mostrar promedio
          if (cantidad != 0){
            double suma = 0;
            for (int i = 0; i < maxAlumnos; i++) {
              if (alumnos[i] != null){
                suma += notas[i];
              }
            }
            double promedio = suma / cantidad;
            System.out.println("Promedio: " + promedio);
          } else {
            System.out.println("No hay alumnos");
          }
          break;
        case 4:
          // buscar alumno
          if (cantidad != 0) {
            System.out.print("Ingrese el nombre del alumno que quiere buscar: ");
            String nombre4 = sc.nextLine();
  
            boolean encontrado4 = false;
            for (int i = 0; i < maxAlumnos; i++) {
              if (alumnos[i] != null && alumnos[i].equals(nombre4)){
                encontrado4 = true;
                System.out.println("Nota del alumno " + nombre4 + ": " + notas[i]);
              }
            }
  
            if (!encontrado4) {
              System.out.println("Ese alumno no existe.");
            }
          } else {
            System.out.println("No hay alumnos");
          }
          break;
        case 5:
          // modificar nota
          if (cantidad != 0) {
            System.out.print("Ingrese el nombre del alumno para modificar la nota: ");
            String nombre5 = sc.nextLine();

            boolean encontrado5 = false;
            for (int i = 0; i < maxAlumnos; i++) {
              if (alumnos[i] != null && alumnos[i].equals(nombre5)){
                encontrado5 = true;
                System.out.println("Alumno encontrado");
                System.out.print("Ingrese la nota nueva: ");
                double notaNueva = sc.nextDouble();
                sc.nextLine();
                if (notaNueva < 0 || notaNueva > 10){
                  System.out.println("Nota inválida");
                } else {
                  notas[i] = notaNueva;
                  System.out.println("Nueva nota del alumno " + nombre5 + ": " + notas[i]);
                }
              }
            }

            if (!encontrado5) {
              System.out.println("Ese alumno no existe.");
            }
          } else {
            System.out.println("No hay alumnos");
          }
          break;
        case 6:
          // eliminar alumno
          if (cantidad != 0) {
            System.out.print("Ingrese el nombre del alumno que quiere eliminar: ");
            String nombre6 = sc.nextLine();

            for (int i = 0; i < maxAlumnos; i++) {
              if (alumnos[i] != null && nombre6.equals(alumnos[i])){
                alumnos[i] = null;
                notas[i] = -1;
                cantidad--;
              }
            }
          } else {
            System.out.println("No hay alumnos");
          }

          break;
        case 7:
          // salir
          salir = true;
          break;
        default:
          System.out.println("Opción inválida.");
          break;
      }
      
    }

    sc.close();
  }
}
