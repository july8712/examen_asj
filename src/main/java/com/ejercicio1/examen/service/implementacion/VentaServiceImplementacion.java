package com.ejercicio1.examen.service.implementacion;

import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.entities.ProductoEntity;
import com.ejercicio1.examen.entities.VentaEntity;
import com.ejercicio1.examen.exception.ResourceNotFoundException;
import com.ejercicio1.examen.mapper.VentaMapper;
import com.ejercicio1.examen.repository.ProductoRepository;
import com.ejercicio1.examen.repository.VentaRepository;
import com.ejercicio1.examen.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaServiceImplementacion implements VentaService {

    private final VentaMapper ventaMapper;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public VentaServiceImplementacion(VentaMapper ventaMapper,
                             VentaRepository ventaRepository,
                             ProductoRepository productoRepository) {
        this.ventaMapper = ventaMapper;
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public void crearVentas(VentaDTO ventaDTO) {
        VentaEntity ventaEntity = ventaMapper.toEntity(ventaDTO);
        VentaEntity ventaGuardado = ventaRepository.save(ventaEntity);
    }

    @Override
    public List<VentaDTO> obtenerVentas() throws ResourceNotFoundException {
        List<VentaEntity> listaVentas = ventaRepository.findAll();
        if (listaVentas.isEmpty()) {
            throw new ResourceNotFoundException("Lista vacia");
        }

        List<VentaDTO> listaVentasARetornar = ventaMapper.toListDTO(listaVentas);

        return listaVentasARetornar;
    }

    @Override
    public VentaDTO agregarProductoAVenta(Long idVentas, List<Long> productosId) throws ResourceNotFoundException {
        VentaEntity ventas = ventaRepository.findById(idVentas)
                .orElseThrow(() -> new ResourceNotFoundException("Not found id: " + idVentas));

        List<ProductoEntity> producto = new ArrayList<>();
        for (Long id : productosId) {
            producto.add(productoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not found id: " + id)));
        }
        producto.forEach(ventas::agregarProductos);
        ventaRepository.save(ventas);

        return ventaMapper.obtenerVentaDTO(ventas);
    }

    @Override
    public List<VentaDTO> findByProductoByCategoriaContaining(String word) {

        List<VentaEntity> listaPorCategoria = ventaRepository.findByProductoCategoriaContaining(word);
        List<VentaDTO> listaPorCategoriaDTO = ventaMapper.toListDTO(listaPorCategoria);
        return listaPorCategoriaDTO;
    }


}
