package com.ejercicio1.examen.DTO;

import lombok.Data;

@Data
public class VentaDTO {
    private Long idVenta;
    private Long idProducto;
    private Long idVendedor;
    private double comision;
    private int cantidadProductos;
    private double totalVenta;

}
