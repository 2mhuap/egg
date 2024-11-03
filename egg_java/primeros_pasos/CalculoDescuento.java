import java.util.Scanner;

public class CalculoDescuento {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);
    System.out.print("Ingrese el precio de un producto: ");
    double num = miScanner.nextDouble();

    if (num >= 100) {
      double precioNuevo = num * 0.9;
      System.out.println("Tiene derecho a descuento de 10%. El nuevo precio es S/" + precioNuevo);
    } else {
      System.out.println("No tiene derecho a descuento. El precio es S/" + num);
    }
    miScanner.close();
  }
}
