package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class OrdenandoNombres {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese 4 nombres:");
    String nombre1 = sc.nextLine();
    String nombre2 = sc.nextLine();
    String nombre3 = sc.nextLine();
    String nombre4 = sc.nextLine();

    String[] a = {nombre1, nombre2, nombre3, nombre4};

    if (a[0].compareTo(a[1]) > 0) {
      String temp = a[0];
      a[0] = a[1];
      a[1] = temp;
    }
    if (a[2].compareTo(a[3]) > 0) {
      String temp = a[2];
      a[2] = a[3];
      a[3] = temp;
    }
    if (a[0].compareTo(a[2]) > 0) {
      String temp = a[0];
      a[0] = a[2];
      a[2] = temp;
    }
    if (a[1].compareTo(a[3]) > 0) {
      String temp = a[1];
      a[1] = a[3];
      a[3] = temp;
    }

    System.out.println(Arrays.toString(a));

    sc.close();
  }
}
