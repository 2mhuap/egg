package Math;

public class Aleatorio {
  public static void main(String[] args) {
    int min = 1;
    int max = 355;
    int num = (int)(Math.random() * (max - min + 1)) + min; 
    System.out.println("Número aleatorio de 1-355: " +  num);
  }
}