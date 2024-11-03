import java.util.Scanner;

public class OperacionesBasicas {
  public static void main(String[] args) {

    // Actividad: Operaciones básicas ---------
    // int num1 = 2;
    // int num2 = 3;
    // System.out.println("suma: " + (num1 + num2));
    // System.out.println("resta: " + (num1 - num2));
    // System.out.println("multiplicación: " + (num1 * num2));
    // System.out.println("división: " + (num1 / num2));
    // System.out.println("módulo: " + (num1 % num2));

    // Scanner miScanner = new Scanner(System.in);
    // System.out.println("Ingresa dos numeros.");
    // System.out.print("Primer número: ");
    // int num3 = miScanner.nextInt();
    // System.out.print("Segundo número: ");
    // int num4 = miScanner.nextInt();

    // System.out.println("La suma es " + (num3 + num4));
    // miScanner.close();

    // Actividad: Usando los operadores de comparación
    // Scanner miScanner = new Scanner(System.in);

    // System.out.println("Ingresa dos numeros.");
    // System.out.print("Primer número: ");
    // int num5 = miScanner.nextInt();
    // System.out.print("Segundo número: ");
    // int num6 = miScanner.nextInt();

    // System.out.println(
    // "El número " + num5 + " es mayor a " + num6
    // + "? = " + (num5 > num6));
    // miScanner.close();

    // Actividad: Verificación de edad
    // Scanner miScanner = new Scanner(System.in);
    // System.out.print("Ingresa tu año de nacimiento: ");
    // int anioNacimiento = miScanner.nextInt();
    // int ANIOACTUAL = 2024;
    // int calculoEdad = ANIOACTUAL - anioNacimiento;
    // if (calculoEdad >= 18) {
    // System.out.println("Eres mayor de edad.");
    // } else {
    // System.out.println("No eres mayor de edad.");
    // }
    // miScanner.close();

    // Actividad: Calculadora de area y perimetro
    Scanner miScanner = new Scanner(System.in);
    System.out.print("Ingresa valor de la base: ");
    int base = miScanner.nextInt();
    System.out.print("Ingresa valor de la altura: ");
    int altura = miScanner.nextInt();

    int perimetro = 2 * base + 2 * altura;
    System.out.println("El perimetro es: " + perimetro);
    int area = base * altura;
    System.out.println("El área es: " + area);

    miScanner.close();
  }
}