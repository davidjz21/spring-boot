package com.example.libreria.controlador;

import com.example.libreria.model.Libros;
import com.example.libreria.servicio.I_ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {
    private final I_ServicioLibro i_servicio;

    // inyeccion de dependencias por constructor //
    public ControladorLibreria(I_ServicioLibro i_servicio) {
        this.i_servicio = i_servicio;

    }

    @GetMapping("/todos")
    public List<Libros>listar() {
        return i_servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> obtenerPorId(@PathVariable long id) {
        Optional<Libros> libro = i_servicio.obtenerPorId(id);
        return libro.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libros>crear(@RequestBody Libros libro) {
        i_servicio.guardar(libro);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> elminar(@PathVariable long id) {
        i_servicio.eliminaPorId(id);
        return ResponseEntity.noContent().build();
    }

}
