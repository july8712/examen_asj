package com.ejercicio1.examen.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;

    @Column(length = 70)
    private String codigo;

    @Column(name = "nombre_producto",length = 50, nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private double precio;

    @Column(name = "id_categoria")
    private double idCategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    private Venta venta;
}
