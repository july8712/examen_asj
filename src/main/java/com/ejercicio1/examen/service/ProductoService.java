package com.ejercicio1.examen.service;

import com.ejercicio1.examen.DTO.ProductoDTO;
import com.ejercicio1.examen.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductoService {

    ProductoDTO crearProducto (ProductoDTO productoDTO);

    List<ProductoDTO> obtenerProducto () throws ResourceNotFoundException;

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) throws ResourceNotFoundException;

    void eliminarProducto(Long id) throws ResourceNotFoundException;
}
