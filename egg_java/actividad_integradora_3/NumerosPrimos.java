package actividad_integradora_3;

import java.util.Scanner;

public class NumerosPrimos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean primo;
    do {
      System.out.println("Ingrese un número entero: ");
      int num = sc.nextInt();
      primo = isPrime(num);
      
    } while (!primo);

    sc.close();
  }

  static boolean isPrime(int n) {
    if (n <= 1){
      return false;
    }

    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }    

    return true;
  }
}
