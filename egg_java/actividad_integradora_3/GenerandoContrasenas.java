package actividad_integradora_3;

import java.util.Scanner;

public class GenerandoContrasenas {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Ingrese la longitud de la contraseña: ");
    int length = sc.nextInt();

    int min = 0;
    int max = 2;

    // mayusculas: 65-90
    // minusculas: 97-122
    // digitos: 48-57

    int minMay = 65;
    int maxMay = 90;
    int minMin = 97;
    int maxMin = 122;
    int minDig = 48;
    int maxDig = 57;

    char[] contra = new char[length];

    boolean mayuscula = false;
    boolean minuscula = false;
    boolean digito = false;

    int intentos = 1;

    while (!(mayuscula & minuscula & digito)) {
      System.out.println("Intento: " + intentos);
      for (int i = 0; i < length; i++) {
        int num = (int)(Math.random() * (max - min + 1)) + min; 
        contra[i] = switch (num) {
          case 0 -> {
            // mayuscula
            mayuscula = true;
            int mayNum = (int)(Math.random() * (maxMay - minMay + 1)) + minMay;
            yield (char) mayNum; 
          }
          case 1 -> {
            // minuscula
            minuscula = true;
            int minNum = (int)(Math.random() * (maxMin - minMin + 1)) + minMin;
            yield (char) minNum; 
          }
          default -> {
            // digitos
            digito = true;
            int digNum = (int)(Math.random() * (maxDig - minDig + 1)) + minDig;
            yield (char) digNum; 
          }
        };
      }
      intentos++;
    }
    
    String contraStr = new String(contra);
    System.out.println(contraStr);

    sc.close();
  }
}
