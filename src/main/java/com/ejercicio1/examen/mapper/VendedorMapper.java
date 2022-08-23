package com.ejercicio1.examen.mapper;

import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.entities.Vendedor;
import com.ejercicio1.examen.entities.Venta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendedorMapper {
    @Autowired
    private ObjectMapper objectMapper;
    public Vendedor toEntity(VendedorDTO vendedorDTO){
        return objectMapper.convertValue(vendedorDTO, Vendedor.class);

    }
    public VendedorDTO toDTO(Vendedor vendedor){
        return objectMapper.convertValue(vendedor, VendedorDTO.class);
    }
}
