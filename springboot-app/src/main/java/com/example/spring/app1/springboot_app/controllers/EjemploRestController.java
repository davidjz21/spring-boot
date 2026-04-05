package com.example.spring.app1.springboot_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.app1.springboot_app.models.dto.ClaseDTO;

@RestController
@RequestMapping("/api")
public class EjemploRestController {
    @GetMapping(path = "/detalles_info2")

    public ClaseDTO detalles_info2() {

        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("administrador");
        usuario1.setUsuario("Arch");
        return usuario1;
    }
}
