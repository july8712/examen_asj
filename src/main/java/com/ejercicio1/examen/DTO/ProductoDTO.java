package com.ejercicio1.examen.DTO;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long codigo;
    private String nombre;
    private double precio;
    private String categoria;
}
