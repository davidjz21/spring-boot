package com.example.libreria.repoLibros;

import com.example.libreria.model.Libros;

import java.util.List;
import java.util.Optional;

public interface I_Repolibros {
    List<Libros> findAll();
    Optional<Libros>findById(long id);
    void save(Libros libro);
    void deleteById(long id);
}
