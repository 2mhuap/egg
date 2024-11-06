package com.egg.biblioteca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;

import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class LibroServicio {
  @Autowired
  private LibroRepositorio libroRepositorio;
  @Autowired
  private AutorRepositorio autorRepositorio;
  @Autowired
  private EditorialRepositorio editorialRepositorio;

  public void crearLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
    validar(isbn, titulo, ejemplares, idAutor, idEditorial);
    Libro libro = new Libro();
    libro.setIsbn(isbn);
    libro.setTitulo(titulo);
    libro.setEjemplares(ejemplares);
    libro.setAlta(new Date());
    Autor autor = autorRepositorio.findById(idAutor).get();
    libro.setAutor(autor);
    Editorial editorial = editorialRepositorio.findById(idEditorial).get();
    libro.setEditorial(editorial);

    libroRepositorio.save(libro);
  }

  @Transactional(readOnly = true)
  public List<Libro> listarLibros() {
    List<Libro> libros = new ArrayList<>();
    libros = libroRepositorio.findAll();
    return libros;
  }

  @Transactional
  public void modificarLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
    validar(isbn, titulo, ejemplares, idAutor, idEditorial);
    Optional<Libro> respuestaLibro = libroRepositorio.findById(isbn);
    Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
    Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
    if (respuestaLibro.isPresent() && respuestaAutor.isPresent() && respuestaEditorial.isPresent()){
      Autor autor = respuestaAutor.get();
      Editorial editorial = respuestaEditorial.get();
      Libro libro = respuestaLibro.get();
      libro.setIsbn(isbn);
      libro.setTitulo(titulo);
      libro.setEjemplares(ejemplares);
      libro.setAutor(autor);
      libro.setEditorial(editorial);

      libroRepositorio.save(libro);
    }
  }

  @Transactional(readOnly = true)
  public Libro getOne(Long isbn){
    return libroRepositorio.getReferenceById(isbn);
  }

  private void validar(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
    if (isbn == null){
      throw new MiException("El ISBN no puede ser nulo o estar vacío.");
    }
    if (titulo.isEmpty() || titulo == null){
      throw new MiException("El titulo no puede ser nulo o estar vacío.");
    }
    if (ejemplares < 0 || ejemplares == null) {
      throw new MiException("El número de ejemplares no puede ser nulo o menos de cero");
    }
    if (idAutor == null){
      throw new MiException("El id del autor no puede ser nulo.");
    }
    if (idEditorial == null){
      throw new MiException("El id del editorial no puede ser nulo.");
    }
  }
}
