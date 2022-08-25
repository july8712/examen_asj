package com.ejercicio1.examen.mapper;

import com.ejercicio1.examen.DTO.ProductoDTO;
import com.ejercicio1.examen.entities.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class ProductoMapper {
    public ProductoEntity toEntity(ProductoDTO productoDTO){
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setCodigo(productoDTO.getCodigo());
        productoEntity.setNombre(productoDTO.getNombre());
        productoEntity.setPrecio(productoDTO.getPrecio());
        productoEntity.setCategoria(productoDTO.getCategoria());

        return productoEntity;
    }

    public ProductoDTO toDTO(ProductoEntity productoEntity){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setCodigo(productoEntity.getCodigo());
        productoDTO.setNombre(productoEntity.getNombre());
        productoDTO.setPrecio(productoEntity.getPrecio());
        productoDTO.setCategoria(productoEntity.getCategoria());

        return productoDTO;
    }


    public List<ProductoDTO> toListDTO(List<ProductoEntity> list){
        return list.stream()
                .map(this::toDTO)
                .collect(toList());
    }

    public ProductoEntity toSet(ProductoEntity productoEntity, ProductoDTO productoDTO){
        ProductoEntity productoActualizado = new ProductoEntity();
        productoActualizado.setNombre(productoDTO.getNombre());
        productoActualizado.setPrecio(productoDTO.getPrecio());
        productoActualizado.setCodigo(productoDTO.getCodigo());
        return productoActualizado;
    }

    public Set<ProductoDTO> setProductoDTO(Set<ProductoEntity> productoEntitySet){
        return productoEntitySet.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
