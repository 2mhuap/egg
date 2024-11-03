package com.egg.biblioteca.controladores;

// import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.EditorialServicio;

@Controller
@RequestMapping("/editorial")
public class EditorialControlador {
  @Autowired
  private EditorialServicio editorialServicio;

  @GetMapping("/registrar")
  public String registrar(){
    return "editorial_form.html";
  }

  @PostMapping("/registro")
  public String registro(@RequestParam String nombre, ModelMap modelo){
    try {
      Logger.getLogger(EditorialControlador.class.getName()).info("Creando editorial...");
      editorialServicio.crearEditorial(nombre);
      modelo.put("exito", "El editorial fue cargado correctamente!");
    } catch (MiException e) {
      // Logger.getLogger(EditorialControlador.class.getName()).log(Level.SEVERE, null, e);
      Logger.getLogger(EditorialControlador.class.getName()).info(e.getMessage());
      modelo.put("error", e.getMessage());
      return "editorial_form.html";
    }
    return "index.html";
  }
}
