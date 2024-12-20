package com.egg.biblioteca.controladores;

import java.util.List;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;

@Controller
@RequestMapping("/libro")
public class LibroControlador {
  @Autowired
  private LibroServicio libroServicio;
  @Autowired
  private AutorServicio autorServicio;
  @Autowired
  EditorialServicio editorialServicio;

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("/registrar")
  public String registrar(ModelMap modelo) {
    popularListas(modelo);
    return "libro_form.html";
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("/registro")
  public String registro(
      @RequestParam(required = false) Long isbn,
      @RequestParam String titulo,
      @RequestParam(required = false) Integer ejemplares,
      @RequestParam(required = false) UUID idAutor,
      @RequestParam(required = false) UUID idEditorial,
      ModelMap modelo) {
    try {
      libroServicio.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
      modelo.put("exito", "El libro fue cargado correctamente!");
    } catch (MiException e) {
      // Logger.getLogger(LibroControlador.class.getName()).log(Level.SEVERE, null,
      // e);
      popularListas(modelo);
      modelo.put("error", e.getMessage());
      return "libro_form.html";
    }
    return "index.html";
  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @GetMapping("/lista")
  public String listar(ModelMap modelo) {
    List<Libro> libros = libroServicio.listarLibros();
    modelo.put("libros", libros);
    return "libro_list.html";
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("/modificar/{isbn}")
  public String modificar(@PathVariable Long isbn, ModelMap modelo) {
    modelo.put("libro", libroServicio.getOne(isbn));
    popularListas(modelo);
    return "libro_modificar.html";
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("{isbn}")
  public String modificar(@PathVariable Long isbn, String titulo, Integer ejemplares, UUID idAutor,
      UUID idEditorial, ModelMap modelo) {
    try {

      libroServicio.modificarLibro(isbn, titulo, ejemplares, idAutor, idEditorial);

      return "redirect:../libro/lista";

    } catch (MiException ex) {
      modelo.put("error", ex.getMessage());

      popularListas(modelo);
      return "libro_modificar.html";
    }

  }

  private void popularListas(ModelMap modelo) {
    List<Autor> autores = autorServicio.listarAutores();
    List<Editorial> editoriales = editorialServicio.listaEditoriales();
    modelo.put("autores", autores);
    modelo.put("editoriales", editoriales);

    if (autores.isEmpty() || editoriales.isEmpty()) {
      String warning = "No se puede agregar un libro porque no existen ";
      if (autores.isEmpty() && !editoriales.isEmpty()) {
        warning += "autores ";
      } else if (autores.isEmpty() && editoriales.isEmpty()) {
        warning += "autores o editoriales ";
      } else if (!autores.isEmpty() && editoriales.isEmpty()) {
        warning += "editoriales ";
      }
      warning += "para seleccionar.";

      modelo.put("warning", warning);
    }
  }

}
