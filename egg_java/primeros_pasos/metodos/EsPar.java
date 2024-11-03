package metodos;

import java.util.Scanner;

public class EsPar {
  public static Scanner pepe = new Scanner(System.in);
  public static void main(String[] args) {
    
    Integer numero = solicitarNumero();
    if (esPar(numero)) {
      System.out.println("El "+numero+" es par");
    }

    pepe.close();
  }

  public static Integer solicitarNumero(){
    Integer numero = null;
    do {
      try {
        System.out.println("Por favor ingrese un número:");
        numero = pepe.nextInt();
      } catch (Exception e) {
        pepe.nextLine();
        System.out.println("No ingresó un número, intente nuevamente:");
      }
    } while (numero == null);

    return numero;
  }

  public static boolean esPar(Integer n){
    return n % 2 == 0;
  }

  

}
