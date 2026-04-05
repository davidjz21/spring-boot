package com.hibernate.ferreteria.controladores;

import com.hibernate.ferreteria.dto.ArticulosDTO;
import com.hibernate.ferreteria.entity.Articulos;
import com.hibernate.ferreteria.mapper.ArticuloMapper;
import com.hibernate.ferreteria.repositorios.Repo_articulos;
import com.hibernate.ferreteria.servicios.ArticulosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
    @Autowired
    private ArticulosServices servicio;

    @GetMapping
    public List<ArticulosDTO> listar() {
        return servicio.Consulta();
    }
}
