package com.ejercicio1.examen.mapper;

import com.ejercicio1.examen.DTO.ProductoDTO;
import com.ejercicio1.examen.entities.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public Producto toEntity(ProductoDTO productoDTO){
        return objectMapper.convertValue(productoDTO, Producto.class);

    }
    public ProductoDTO toDTO(Producto producto){
        return objectMapper.convertValue(producto, ProductoDTO.class);

    }
}
