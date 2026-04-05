package com.example.libreria.servicio;

import com.example.libreria.model.Libros;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface I_ServicioLibro {
    List<Libros>obtenerTodos();
    Optional<Libros>obtenerPorId(long id);
    Libros guardar(Libros libro);
    void eliminaPorId(long id);
    String buscaLibroPorTitulo(String titulo);

}
