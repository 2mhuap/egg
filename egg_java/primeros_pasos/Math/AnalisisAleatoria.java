package Math;
import java.util.Scanner;

public class AnalisisAleatoria {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese un número entero entre 1 y 30: ");
    int numeroLimite = miScanner.nextInt();

    if (numeroLimite >= 1 && numeroLimite <= 30){
      int min = 1;
      int max = numeroLimite;
      int aleatorio = (int)(Math.random() * (max - min + 1)) + min; 
      System.out.println("El número aleatorio generado es: " + aleatorio);
      double sqrt = Math.sqrt(aleatorio);
      boolean primo = isPrime(aleatorio);
      System.out.println("Raíz cuadrada: " + sqrt);
      if (primo) {
        System.out.println("El número aleatorio es primo.");
      } else {
        System.out.println("El número aleatorio generado no es primo.");
      }
    } else {
      System.out.println("Número invalido.");
    }

    miScanner.close();
  }

  public static boolean isPrime(double n) {
    if (n <= 1) {
      return false;
    }

    for (int i = 2; i < n; i++) {
      if (n % i == 0){
        return false;
      }
    }

    return true;
  }
}