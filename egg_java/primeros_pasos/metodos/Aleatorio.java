package metodos;

public class Aleatorio {
  public static void main(String[] args) {
    int n = numeroAleatorio();
    System.out.println("Número aleatorio de 1-355: " +  n);
  }

  public static int numeroAleatorio() {
    int min = 1;
    int max = 355;
    int num = (int)(Math.random() * (max - min + 1)) + min;
    return num; 
  }
}