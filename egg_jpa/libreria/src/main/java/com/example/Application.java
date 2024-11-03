package com.example;

import com.example.entidades.Autor;
import com.example.entidades.Editorial;
import com.example.servicios.AutorServicio;
import com.example.servicios.EditorialServicio;
import com.example.servicios.LibroServicio;

public class Application {

    public static void main(String[] args) {
        // AutorServicio aServicio = new AutorServicio();
        // aServicio.crearAutor("AutorA", false);
        // aServicio.crearAutor("AutorB", false);
        // aServicio.crearAutor("AutorC", false);
        // aServicio.listarAutores();
        // Autor a = aServicio.buscarAutorPorId(2);
        // aServicio.cerrar();

        // EditorialServicio eServicio = new EditorialServicio();
        // eServicio.crearEditorial("EditorialA");
        // eServicio.crearEditorial("EditorialB");
        // eServicio.crearEditorial("EditorialC");
        // eServicio.listarEditoriales();
        // eServicio.borrarEditorial(2);
        // eServicio.listarEditoriales();
        // Editorial e = eServicio.buscarEditorialPorId(3);
        // eServicio.cerrar();

        LibroServicio lServicio = new LibroServicio();
        // lServicio.crearLibro(9789027439642L, "LibroA", 2024, 5, false, a, e);
        // lServicio.crearLibro(9789027439644L, "LibroB", 2023, 5, false, a, e);
        // lServicio.listarLibros();
        // lServicio.buscarPorISBN(9789027439642L);
        // lServicio.buscarLibroPorTitulo("LibroB");
        lServicio.buscarLibroPorAutor("AutorB");
        lServicio.cerrar();

        System.out.println("FIN");
    }
}
