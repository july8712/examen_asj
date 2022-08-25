package com.ejercicio1.examen.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class VendedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nombre_vendedor",length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double sueldo;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<VentaEntity> ventasEntities = new ArrayList<>();

    @Override
    public String toString() {
        return "VendedorEntity{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
