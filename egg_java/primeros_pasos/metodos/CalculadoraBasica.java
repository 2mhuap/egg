package metodos;

import java.util.Scanner;

public class CalculadoraBasica {

  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    menu();
    sc.close();
  }

  public static void menu() {
    System.out.print("Ingrese un número: ");
    double num1 = sc.nextDouble();
    System.out.print("Ingrese otro número: ");
    double num2 = sc.nextDouble();

    boolean salir = false;
    while (!salir){
      System.out.print("""
        Operaciones:
        1. Suma
        2. Resta
        3. Multiplicación
        4. División
        5. Módulo
        6. Salir
        """);
      System.out.print("Escoja una operación: ");
      int op = sc.nextInt();
      switch (op) {
        case 1 -> suma(num1, num2);
        case 2 -> resta(num1, num2);
        case 3 -> multiplicacion(num1, num2);
        case 4 -> division(num1, num2);
        case 5 -> modulo(num1, num2);
        case 6 -> salir = true;
        default -> System.out.println("Error: no existe esa operación.");
      }
    }
  }

  public static void imprimirResultado(String opString, double resultado) {
    System.out.println("Operación: " + opString);
    System.out.println("El resultado es " + resultado);
  }

  public static void suma(double num1, double num2){
    double resultado = num1 + num2;
    imprimirResultado("suma", resultado);
  }

  public static void resta(double num1, double num2){
    double resultado = num1 - num2;
    imprimirResultado("resta", resultado);
  }

  public static void multiplicacion(double num1, double num2){
    double resultado = num1 * num2;
    imprimirResultado("multiplicación", resultado);
  }

  public static void division(double num1, double num2){
    if (num2 == 0){
      System.out.println("Error: No se puede dividir por 0.");
    } else {
      double resultado = num1 / num2;
      imprimirResultado("división", resultado);
    }
  }

  public static void modulo(double num1, double num2){
    double resultado = num1 % num2;
    imprimirResultado("módulo", resultado);
  }

  
}
