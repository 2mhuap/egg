package com.egg.biblioteca.controladores;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class PortalControlador {

  @Autowired
  private UsuarioServicio usuarioServicio;

  @GetMapping("/")
  public String index(){
    return "index.html";
  }

  @GetMapping("/registrar")
  public String registrar() {
    return "registro.html";
  }

  @PostMapping("/registro")
  public String registro(
    @RequestParam String nombre,
    @RequestParam String email,
    @RequestParam String password,
    @RequestParam String password2,
    @RequestParam(required = false) MultipartFile archivo,
    ModelMap modelo
  ) {
    try {
      usuarioServicio.registrar(nombre, email, password, password2, archivo);
    } catch (MiException e) {
      Logger.getLogger(PortalControlador.class.getName()).info(e.getMessage());
      modelo.put("error", e.getMessage());
      return "registrar.html";
    }
    return "inicio.html";
  }

  @GetMapping("/login")
  public String login(@RequestParam(required = false) String error, ModelMap modelo) {
    if (error != null){
      modelo.put("error", "Usuario o contraseña inválidos!");
    }
    return "login.html";
  }

  @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
  @GetMapping("/inicio")
  public String inicio(HttpSession session) {
    Usuario logeado = (Usuario) session.getAttribute("usuariosession");
    if (logeado != null && logeado.getRol().equals(Rol.ADMIN)){
      return "redirect:/admin/dashboard";
    }
    return "inicio.html";
  }


}
