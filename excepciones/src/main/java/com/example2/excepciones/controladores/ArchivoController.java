package com.example2.excepciones.controladores;

import com.example2.excepciones.servicio.FileContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

    public final FileContent v_contenido;

    public ArchivoController(FileContent contenido) {
        this.v_contenido = contenido;
    }

    @GetMapping("/lectura")
    public ResponseEntity<String> lectura(@RequestParam String ruta) {
        try {
            String elArchivo = v_contenido.LecturaArchivo(ruta);
            return ResponseEntity.ok(elArchivo);
        } catch (RuntimeException ERROR) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error de lectura de archivo" + ERROR);
        }
    }

}
