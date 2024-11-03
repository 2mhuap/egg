import java.util.Scanner;

public class BusquedaCaracteres {
  public static void main(String[] args) {
    Scanner miScanner = new Scanner(System.in);

    System.out.print("Ingrese una palabra: ");
    String str1 = miScanner.nextLine();
    System.out.print("Ingrese un carácter: ");
    char ch = miScanner.nextLine().charAt(0);
    int index = str1.indexOf(ch);

    if (index == -1){
      System.out.println("No se encuentra el carácter (" + ch + ") en la palabra");
    } else {
      System.out.println("Si se encuentra el carácter (" + ch + ") en la palabra");
    }
    
    miScanner.close();
  }
}