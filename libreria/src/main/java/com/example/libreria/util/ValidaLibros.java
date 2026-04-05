package com.example.libreria.util;

import com.example.libreria.model.Libros;
import org.springframework.stereotype.Component;

@Component
public class ValidaLibros {
    public Libros libro;

    public boolean tituloValido() {
        return libro.getTitulo() != null && !Boolean.parseBoolean(libro.getTitulo());
    }
}
