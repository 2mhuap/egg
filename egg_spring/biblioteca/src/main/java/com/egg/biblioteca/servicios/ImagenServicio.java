package com.egg.biblioteca.servicios;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.egg.biblioteca.entidades.Imagen;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.ImagenRepositorio;

@Service
public class ImagenServicio {
  @Autowired
  private ImagenRepositorio imagenRepositorio;

  @Transactional
  public Imagen guardar(MultipartFile archivo) throws MiException {
    if (archivo != null){
      try {
        Imagen imagen = new Imagen();
        imagen.setNombre(archivo.getName());
        imagen.setContenido(archivo.getBytes());
        imagenRepositorio.save(imagen);
        return imagen;
      } catch (IOException e) {
        throw new MiException(e.getMessage());
      } 
    }
    return null;
  }

}
