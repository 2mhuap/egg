package actividad_integradora_4;

import java.util.Arrays;
import java.util.Scanner;

public class DibujandoCuadrados {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese un número entero (tamaño del cuadrado): ");
    int tam = sc.nextInt();

    String resultado = "";
    for (int i = 0; i < tam; i++) {
      if (i == 0 || i == tam - 1){
        char[] chArr = new char[tam];
        Arrays.fill(chArr, '*');
        String s = new String(chArr).concat("\n");
        resultado += s;
      } else {
        char[] spArr = new char[tam - 2];
        Arrays.fill(spArr, ' ');
        String s = "*" + new String(spArr) + "*\n";
        resultado += s;
      }
    }

    System.out.print(resultado);

    sc.close();
  }
}
