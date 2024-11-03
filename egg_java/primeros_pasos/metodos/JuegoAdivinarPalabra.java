package metodos;

import java.util.Arrays;
import java.util.Scanner;

public class JuegoAdivinarPalabra {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    String[] palabras = {"hola", "mundo", "egg", "no", "gato", "perro"};
    int limiteIntentos = 3;

    String palabraCorrecta = palabraAleatoria(palabras);
    int longitud = palabraCorrecta.length();
    System.out.println("Longitud: " + longitud);
    char[] pista = new char[longitud];
    Arrays.fill(pista, '_');
    int letrasCorrectas = 0;

    imprimirPista(pista);

    int intento = 0;
    while ((letrasCorrectas != longitud) && intento < 3){
      System.out.println("Quedan " + (limiteIntentos - intento) + " intentos.");
      char letra = pedirLetra();
      boolean letraEncontrada = false;
      for (int i = 0; i < longitud; i++) {
        if (letra == palabraCorrecta.charAt(i)){
          pista[i] = letra;
          letrasCorrectas++;
          letraEncontrada = true;
        }
      }
      if (!letraEncontrada){
        intento++;
        System.out.println("No se encuentra esa letra en la palabra.");
      }
      imprimirPista(pista);
    }

    if (letrasCorrectas == longitud) {
      System.out.println("Adivinaste la palabra!");
    } else {
      System.out.println("No encontraste la palabra: " + palabraCorrecta);
    }

    sc.close();
  }

  public static String palabraAleatoria(String[] palabras){
    int i = numeroAleatorio(palabras.length - 1);
    return palabras[i];
  }

  public static int numeroAleatorio(int max) {
    int min = 0;
    int num = (int)(Math.random() * (max - min + 1)) + min;
    return num; 
  }

  public static void imprimirPista(char[] pista){
    String p = "";
    for (int i = 0; i < pista.length; i++) {
      p += pista[i] + " ";
    }
    System.out.println("Pista: " + p);
  }

  public static char pedirLetra() {
    System.out.print("Adivina una letra: ");
    return sc.nextLine().charAt(0);
  }
}
