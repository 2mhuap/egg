package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RellenandoPersonalizado {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese el tamaño del array: ");
    int length = sc.nextInt();
    int[] a = new int[length];
    System.out.print("Ingrese un número con el que quieras rellenar: ");
    int num = sc.nextInt();
    System.out.print("Ingrese el índice (inclusivo) hasta el cual quiera rellenar el array: ");
    int ind = sc.nextInt();

    if (ind < length) {
      Arrays.fill(a, 0, ind + 1, num);
      while(ind != length - 1) {
        System.out.println("Has rellenado hasta el indice " + ind + " (inclusivo) pero queda espacio.");

        int resto = length - 1 - ind;
        String x = new String(new char[resto]).replace("\0", "x, ");
        x = x.substring(0, x.length() - 2);
        String rellenado = Arrays.toString(Arrays.copyOfRange(a, 0, ind + 1));
        rellenado = rellenado.substring(0, rellenado.length() - 1);
        System.out.println(rellenado + ", " + x + "]");

        int indAnt = ind;
        System.out.print("Ingrese otro número con el que quieras rellenar: ");
        num = sc.nextInt();
        System.out.print("Ingrese otro índice hasta el cual quiera rellenar el array: ");
        ind = sc.nextInt();

        if (ind > indAnt && ind < length){
          Arrays.fill(a, indAnt + 1, ind + 1, num);
        } else {
          System.out.println("Índice invalido");
          ind = indAnt;
        }
      }

      System.out.println(Arrays.toString(a));
    } else {
      System.out.println("Índice invalido");
    }
    sc.close();
  }
}
