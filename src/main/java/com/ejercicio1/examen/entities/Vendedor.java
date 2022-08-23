package com.ejercicio1.examen.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Vendedores")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vendedor")
    private Long idVendedor;

    @Column(length = 70)
    private String codigo;

    @Column(name = "nombre_vendedor",length = 50, nullable = false)
    private String nombreVendedor;

    @Column(nullable = false)
    private double sueldo;

    @OneToMany(mappedBy = "vendedor",cascade = CascadeType.ALL)
    private List<Venta> listaVentas = new ArrayList<>(); //
}
