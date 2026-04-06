package com.hibernate.ferreteria.servicios;

import com.hibernate.ferreteria.dto.ArticulosDTO;
import com.hibernate.ferreteria.entity.Articulos;
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

    public List<ArticulosDTO> serv_consulta() {
        return repo.findAll().stream().map(ArticuloMapper::toDTO)
                .collect(Collectors.toList());

    }

    public ArticulosDTO serv_inserta(ArticulosDTO dto) {
        Articulos articulo = ArticuloMapper.toEntity(dto);
        Articulos insertado = repo.save(articulo);
        return ArticuloMapper.toDTO(insertado);
    }
}
