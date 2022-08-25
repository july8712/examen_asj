package com.ejercicio1.examen.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class VentaDTO {

    private Long codigo;

    private VendedorDTO vendedorDTO;

    private Set<ProductoDTO> producto;
}



