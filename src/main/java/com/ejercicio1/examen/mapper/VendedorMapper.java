package com.ejercicio1.examen.mapper;

import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.entities.VendedorEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VendedorMapper {
    public VendedorEntity toEntity(VendedorDTO vendedorDTO){
        VendedorEntity vendedorEntity = new VendedorEntity();
        vendedorEntity.setCodigo(vendedorDTO.getCodigo());
        vendedorEntity.setNombre(vendedorDTO.getNombre());
        vendedorEntity.setSueldo(vendedorDTO.getSueldo());
        return vendedorEntity;
    }

    public VendedorDTO toDTO(VendedorEntity vendedorEntity){
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setCodigo(vendedorEntity.getCodigo());
        vendedorDTO.setNombre(vendedorEntity.getNombre());
        vendedorDTO.setSueldo(vendedorEntity.getSueldo());
        return vendedorDTO;
    }

    public List<VendedorDTO> toListDTO(List<VendedorEntity> list){
        List<VendedorDTO> lista = new ArrayList<>();

        for (VendedorEntity vendedorEntity : list) {
            lista.add(toDTO(vendedorEntity));
        }

        return lista;
    }

    public VendedorEntity toSet(VendedorEntity vendedorEntity, VendedorDTO vendedorDTO){
        VendedorEntity vendedorActualizado = new VendedorEntity();
        vendedorActualizado.setNombre(vendedorDTO.getNombre());
        vendedorActualizado.setSueldo(vendedorDTO.getSueldo());
        vendedorActualizado.setCodigo(vendedorDTO.getCodigo());

        return vendedorActualizado;
    }
}
