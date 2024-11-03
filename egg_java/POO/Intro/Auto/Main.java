package POO.Intro.Auto;

public class Main {
  public static void main(String[] args) {
    Auto a1 = new Auto("Honda", "Accord", 2024); 
    Auto a2 = new Auto("Chevrolet", "Corvette"); 
    Auto a3 = new Auto("Hyundai"); 
    Auto a4 = new Auto(); 

    a1.imprimirDatos();
    a2.imprimirDatos();
    a3.imprimirDatos();
    a4.imprimirDatos();
  }
}
