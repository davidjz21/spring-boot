package com.hibernate.ferreteria.controladores;

import com.hibernate.ferreteria.dto.ArticulosDTO;
import com.hibernate.ferreteria.entity.Articulos;
import com.hibernate.ferreteria.mapper.ArticuloMapper;
import com.hibernate.ferreteria.repositorios.Repo_articulos;
import com.hibernate.ferreteria.servicios.ArticulosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {
    @Autowired
    private ArticulosServices servicio;

    @GetMapping
    public List<ArticulosDTO> listar() {
        return servicio.serv_consulta();
    }

    @PostMapping
    public ArticulosDTO insertaArticulo(@RequestBody ArticulosDTO dto) {
        return servicio.serv_inserta(dto);
    }

    @PutMapping("/{id}")
    public ArticulosDTO actualizaArticulo(@PathVariable Long id, @RequestBody ArticulosDTO dto) {
        return servicio.serv_actualiza(id, dto);
    }
}
