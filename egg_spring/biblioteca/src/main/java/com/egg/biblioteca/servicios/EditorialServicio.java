package com.egg.biblioteca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.EditorialRepositorio;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Optional;

@Service
public class EditorialServicio {
  @Autowired
  private EditorialRepositorio editorialRepositorio;

  @Transactional
  public void crearEditorial(String nombre) throws MiException {
    validar(nombre);
    Editorial editorial = new Editorial();
    editorial.setNombre(nombre);

    editorialRepositorio.save(editorial);
  }

  @Transactional(readOnly = true)
  public List<Editorial> listaEditoriales(){
    List<Editorial> editoriales = new ArrayList<>();
    editoriales = editorialRepositorio.findAll();
    return editoriales;
  }

  @Transactional
  public void modificarEditorial(String nombre, UUID id) throws MiException {
    validar(nombre);
    Optional<Editorial> respuesta = editorialRepositorio.findById(id);
    if (respuesta.isPresent()) {
      Editorial editorial = respuesta.get();
      editorial.setNombre(nombre);
      editorialRepositorio.save(editorial);
    }
  }

  @Transactional(readOnly = true)
  public Editorial getOne(UUID id){
    return editorialRepositorio.getReferenceById(id);
  }

  private void validar(String nombre) throws MiException {
    if (nombre.isEmpty() || nombre == null){
      throw new MiException("El nombre no puede ser nulo o estar vacío.");
    }
  }
}
