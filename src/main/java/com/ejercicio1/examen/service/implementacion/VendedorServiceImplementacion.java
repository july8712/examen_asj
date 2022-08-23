package com.ejercicio1.examen.service.implementacion;

import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.entities.Vendedor;
import com.ejercicio1.examen.mapper.VendedorMapper;
import com.ejercicio1.examen.repository.VendedorRepository;
import com.ejercicio1.examen.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorServiceImplementacion implements VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private VendedorMapper vendedorMapper;

    @Override
    public VendedorDTO save(VendedorDTO productoDTO) { //recibimos productoDTO
        Vendedor vendedor = vendedorMapper.toEntity(productoDTO); //convertimos el productoDTO recibido a un productoEntity
        Vendedor productoGuardado = vendedorRepository.save(vendedor); //guardamos el productoEntity en la base de datos y lo devuelve con un id
        VendedorDTO vendedorDTOConId = vendedorMapper.toDTO(productoGuardado); // convertimos la entidad guardada a un DTO para retornarlo
        return vendedorDTOConId; //retornamos
    }
}
