package POO.Avanzado.GestionCatalogoLibreria.modelos;

public class Libro {
  private String titulo;
  private String autor;
  private String isbn;
  
  public Libro(String titulo, String autor, String isbn) {
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public String getIsbn() {
    return isbn;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Libro other = (Libro) obj;
    if (isbn == null) {
      if (other.isbn != null)
        return false;
    } else if (!isbn.equals(other.isbn))
      return false;
    return true;
  }

  
}
