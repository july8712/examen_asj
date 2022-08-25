package com.ejercicio1.examen.service;

import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.exception.ResourceNotFoundException;

import java.util.List;

public interface VentaService {

    void crearVentas(VentaDTO ventasDTO);

    List<VentaDTO> obtenerVentas() throws ResourceNotFoundException;

    VentaDTO agregarProductoAVenta(Long id, List<Long> productosId) throws ResourceNotFoundException;

    List<VentaDTO>findByProductoByCategoriaContaining(String word);
}
