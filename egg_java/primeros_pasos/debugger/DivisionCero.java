package debugger;

import java.util.Scanner;

public class DivisionCero {
  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Ingrese un número: ");
    int num1 = sc.nextInt();
    System.out.print("Ingrese otro número: ");
    int num2 = sc.nextInt();

    division(num1, num2);
    sc.close();
  }

  public static void division(int num1, int num2) {
    try {
      int resultado = num1 / num2;
      System.out.println(resultado);
    } catch(ArithmeticException e) {
      System.out.println("Error: división por cero.");
    }
  }
  
}
