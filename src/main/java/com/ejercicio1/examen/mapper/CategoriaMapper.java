package com.ejercicio1.examen.mapper;

import com.ejercicio1.examen.DTO.CategoriaDTO;
import com.ejercicio1.examen.entities.Categoria;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
    @Autowired
    private ObjectMapper objectMapper;
    public Categoria toEntity(CategoriaDTO categoriaDTO){
        return objectMapper.convertValue(categoriaDTO, Categoria.class);

    }
    public CategoriaDTO toDTO(Categoria categoria){
        return objectMapper.convertValue(categoria, CategoriaDTO.class);

    }
}
