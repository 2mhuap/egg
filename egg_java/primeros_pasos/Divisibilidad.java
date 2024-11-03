import java.util.Scanner;

public class Divisibilidad {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);
    System.out.print("Ingrese un número: ");
    int num = miScanner.nextInt();
    boolean cinco = num % 5 == 0;
    boolean tres = num % 3 == 0;
    String resultado;
    if (cinco && !tres) {
      resultado = "es divisible por 5.";
    } else if (tres && !cinco) {
      resultado = "es divisible por 3.";
    } else if (cinco && tres) {
      resultado = "es divisible por 5 y 3.";
    } else {
      // !cinco && !tres
      resultado = "no es divisible por 5 o 3.";
    }

    System.out.println("El número " + resultado);
    miScanner.close();
  }
}
