package com.egg.biblioteca.controladores;

import java.util.List;
import java.util.UUID;
// import java.util.logging.Level;
import java.util.logging.Logger;

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
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;

@Controller
@RequestMapping("/autor")
public class AutorControlador {
  @Autowired
  private AutorServicio autorServicio;

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("/registrar")
  public String registrar() {
    return "autor_form.html";
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("/registro")
  public String registro(@RequestParam String nombre, ModelMap modelo) {
    try {
      autorServicio.crearAutor(nombre);
      modelo.put("exito", "El autor fue cargado correctamente!");
    } catch (MiException e) {
      // Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, "Error
      // AUTOR", e);
      Logger.getLogger(AutorControlador.class.getName()).info(e.getMessage());
      modelo.put("error", e.getMessage());

      return "autor_form.html";
    }
    return "index.html";
  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @GetMapping("/lista")
  public String listar(ModelMap modelo) {
    List<Autor> autores = autorServicio.listarAutores();
    modelo.addAttribute("autores", autores);
    return "autor_list.html";
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("/modificar/{id}")
  public String modificar(@PathVariable UUID id, ModelMap modelo) {
    modelo.put("autor", autorServicio.getOne(id));
    return "autor_modificar.html";
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping("{id}")
  public String modificar(@PathVariable UUID id, String nombre, ModelMap modelo) {
    try {
      autorServicio.modificarAutor(nombre, id);
      return "redirect:../autor/lista";
    } catch (MiException ex) {
      modelo.put("error", ex.getMessage());
      return "autor_modificar.html";
    }
  }

}
