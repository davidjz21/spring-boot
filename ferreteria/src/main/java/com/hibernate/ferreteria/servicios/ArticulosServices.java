package com.hibernate.ferreteria.servicios;

import com.hibernate.ferreteria.dto.ArticulosDTO;
import com.hibernate.ferreteria.mapper.ArticuloMapper;
import com.hibernate.ferreteria.repositorios.Repo_articulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticulosServices {
    @Autowired
    private Repo_articulos repo;

    public List<ArticulosDTO> Consulta() {
        return repo.findAll().stream().map(ArticuloMapper::toDTO)
                .collect(Collectors.toList());

    }
}
