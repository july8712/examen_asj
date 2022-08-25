package com.ejercicio1.examen.service.implementacion;

import com.ejercicio1.examen.DTO.ProductoDTO;
import com.ejercicio1.examen.entities.ProductoEntity;
import com.ejercicio1.examen.exception.ResourceNotFoundException;
import com.ejercicio1.examen.mapper.ProductoMapper;
import com.ejercicio1.examen.repository.ProductoRepository;
import com.ejercicio1.examen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplementacion implements ProductoService {

    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImplementacion(ProductoMapper productoMapper,
                               ProductoRepository productoRepository){
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = productoMapper.toEntity(productoDTO);
        ProductoEntity productoGuardado = productoRepository.save(productoEntity);
        ProductoDTO productoARetornar = productoMapper.toDTO(productoGuardado);

        return productoARetornar;
    }

    @Override
    public List<ProductoDTO> obtenerProducto() throws ResourceNotFoundException {
        List<ProductoEntity> listaProductos = productoRepository.findAll();

        if(listaProductos.isEmpty()){
            throw new ResourceNotFoundException("Lista vacia");
        }

        List<ProductoDTO> listaProductosARetornar = productoMapper.toListDTO(listaProductos);

        return listaProductosARetornar;
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) throws ResourceNotFoundException {
        ProductoEntity productoEntity = productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        ProductoEntity productoActualizado = productoMapper.toSet(productoEntity, productoDTO);
        ProductoEntity producto= productoRepository.save(productoActualizado);
        ProductoDTO productoDTO1 = productoMapper.toDTO(producto);

        return productoDTO1;
    }

    @Override
    public void eliminarProducto(Long id) throws ResourceNotFoundException {
        productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        productoRepository.deleteById(id);
    }
}
