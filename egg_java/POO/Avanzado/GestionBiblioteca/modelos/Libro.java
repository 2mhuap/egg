package POO.Avanzado.GestionBiblioteca.modelos;

public class Libro extends ItemBiblioteca implements Catalogable {

  private String titulo;
  private String autor;
  private int numeroDePaginas;
  private boolean prestado = false;
  
  public Libro(String titulo, String autor, int numeroDePaginas, double multaPorDia) {
    super(multaPorDia);
    this.titulo = titulo;
    this.autor = autor;
    this.numeroDePaginas = numeroDePaginas;
  }

  @Override
  public void obtenerInformacion() {
    System.out.println("LIBRO");
    System.out.println("Titulo: " + titulo);
    System.out.println("Autor: " + autor);
    System.out.println("Numero de paginas: " + autor);
    System.out.println(prestado ? "- Prestado" : "- Disponible");
    System.out.println("-----");
  }

  @Override
  public boolean prestar() {
    if (!prestado){
      prestado = true;
      return true;
    }

    System.out.println("El libro no está disponible para prestar.");
    return false;
  }

  @Override
  public void devolver() {
    if (prestado){
      prestado = false;
    } else {
      System.out.println("El libro no está prestado.");
    }
  }

  @Override
  public double calcularMulta() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calcularMulta'");
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public int getNumeroDePaginas() {
    return numeroDePaginas;
  }

  public void setNumeroDePaginas(int numeroDePaginas) {
    this.numeroDePaginas = numeroDePaginas;
  }

  public boolean isPrestado() {
    return prestado;
  }

  
}
