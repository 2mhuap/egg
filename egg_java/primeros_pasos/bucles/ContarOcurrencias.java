package bucles;

import java.util.Scanner;

public class ContarOcurrencias {
  public static void main(String[] args) {
    String frase = "hola mundo hola mundo hola mundo hola mundo hola!x";
    char[] chars = frase.toCharArray();

    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese un carácter: ");
    char c = sc.nextLine().charAt(0);

    int count = 0;
    for (char ch : chars) {
      if (ch == c){
        count++;
      }
    }

    System.out.println(count);
    sc.close();
  }
}
