package com.ejercicio1.examen.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_venta")
    private Long idVenta;

    @Column(name="id_producto")
    private Long idProducto;

    @Column(name = "id_vendedor")
    private Long idVendedor;

    private double comision;

    @Column(name = "cantidad_productos")
    private int cantidadProductos;

    @Column(name = "total_venta")
    private double totalVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<Producto> producto = new ArrayList<>();

}
