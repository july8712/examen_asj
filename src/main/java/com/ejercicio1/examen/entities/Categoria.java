package com.ejercicio1.examen.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria;

    @Column(name="nombre_categoria", length = 50, nullable = false )
    private String nombreCategoria;

    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Producto> listaProductos = new ArrayList<>();
}
