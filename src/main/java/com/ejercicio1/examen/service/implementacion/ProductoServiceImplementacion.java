package com.ejercicio1.examen.service.implementacion;

import com.ejercicio1.examen.DTO.ProductoDTO;
import com.ejercicio1.examen.entities.Producto;
import com.ejercicio1.examen.mapper.ProductoMapper;
import com.ejercicio1.examen.repository.ProductoRepository;
import com.ejercicio1.examen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImplementacion implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) { //recibimos productoDTO
        Producto producto = productoMapper.toEntity(productoDTO); //convertimos el productoDTO recibido a un productoEntity
        Producto productoGuardado = productoRepository.save(producto); //guardamos el productoEntity en la base de datos y lo devuelve con un id
        ProductoDTO productoDTOConId = productoMapper.toDTO(productoGuardado); // convertimos la entidad guardada a un DTO para retornarlo
        return productoDTOConId; //retornamos
    }
}
