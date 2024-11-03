package metodos;

import java.util.Scanner;

public class NumerosPrimosRecursivo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean primo;
    do {
      System.out.print("Ingrese un número entero (hasta que sea primo): ");
      int num = sc.nextInt();
      primo = esPrimo(num, 2);
      
    } while (!primo);
    // System.out.println("Resultado: " + (resultado ? "Es primo" : "No es primo"));
    sc.close();
  }

  public static boolean esPrimo(int num, int i) {
    if (num <= 1){
      return false;
    } 
    
    if (num == 2){
      return true;
    }

    if (num % i == 0){
      return false;
    }

    if (i * i > num){
      return true;
    }

    return esPrimo(num, i+1);

  }
}
