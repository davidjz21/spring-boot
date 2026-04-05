package com.example2.excepciones.servicio;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileContent {
    public String LecturaArchivo(String ruta) {
        try{
            Path v_ruta = Paths.get(ruta);
            return Files.readString(v_ruta);
        } catch (IOException ERROR) {
            throw new RuntimeException("Error en lectura de archivos"
            + ERROR.getMessage(), ERROR);
        }
    }
}
