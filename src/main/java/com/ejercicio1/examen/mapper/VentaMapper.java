package com.ejercicio1.examen.mapper;

import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.entities.Venta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    @Autowired
    private ObjectMapper objectMapper;
    public Venta toEntity(VentaDTO ventaDTO){
        return objectMapper.convertValue(ventaDTO, Venta.class);

    }
    public VentaDTO toDTO(Venta venta){
        return objectMapper.convertValue(venta, VentaDTO.class);

    }
}
