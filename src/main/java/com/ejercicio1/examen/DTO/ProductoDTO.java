package com.ejercicio1.examen.DTO;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long idProducto;
    private String codigo;
    private String nombreProducto;
    private double precio;
    private Long idCategoria;
}
