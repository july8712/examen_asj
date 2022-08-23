package com.ejercicio1.examen.DTO;

import lombok.Data;

@Data
public class VendedorDTO {
    private Long idVendedor;
    private String codigo;
    private String nombreVendedor;
    private double sueldo;
}
