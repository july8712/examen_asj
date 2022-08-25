package com.ejercicio1.examen.DTO;

import lombok.Data;

@Data
public class VendedorDTO {
    private Long codigo;
    private String nombre;
    private double sueldo;
    private double comision;
    private double sueldoTotal;
}
