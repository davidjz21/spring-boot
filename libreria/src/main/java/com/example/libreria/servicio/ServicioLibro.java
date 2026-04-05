package com.example.libreria.servicio;

import com.example.libreria.model.Libros;
import com.example.libreria.repoLibros.I_Repolibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioLibro implements I_ServicioLibro {
    private final I_Repolibros i_repo;

    @Autowired
    public ServicioLibro(I_Repolibros i_repo) {
        this.i_repo = i_repo;
    }

    @Override
    public List<Libros> obtenerTodos() {
        return i_repo.findAll();
    }

    @Override
    public Optional<Libros> obtenerPorId(long id) {
        return i_repo.findById(id);
    }

    @Override
    public Libros guardar(Libros libro) {
        i_repo.save(libro);
        return libro;
    }

    @Override
    public void eliminaPorId(long id) {
        i_repo.deleteById(id);
    }

    @Override
    public String buscaLibroPorTitulo(String titulo) {
        boolean encontrado = i_repo.findAll().stream()
                .anyMatch(libros -> libros.getTitulo() != null && libros.getTitulo().equalsIgnoreCase(titulo));
        return encontrado ? "libro encontrado" : "libro no encontrado";
    }
}
