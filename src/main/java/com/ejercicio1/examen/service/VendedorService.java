package com.ejercicio1.examen.service;

import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.exception.ResourceNotFoundException;

import java.util.List;

public interface VendedorService {

    VendedorDTO crearVendedor (VendedorDTO vendedorDTO);

    List<VendedorDTO> obtenerVendedores () throws ResourceNotFoundException;

    VendedorDTO actualizarVendedor(Long id, VendedorDTO vendedorDTO) throws ResourceNotFoundException;

    void eliminarVendedor(Long id) throws ResourceNotFoundException;
}
