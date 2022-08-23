package com.ejercicio1.examen.service.implementacion;

import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.entities.Venta;
import com.ejercicio1.examen.mapper.VentaMapper;
import com.ejercicio1.examen.repository.VentaRepository;
import com.ejercicio1.examen.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImplementacion implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaMapper ventaMapper;

    @Override
    public VentaDTO save(VentaDTO productoDTO) {
        Venta venta = ventaMapper.toEntity(productoDTO);
        Venta ventaGuardado = ventaRepository.save(venta);
        VentaDTO ventaDTOConId = ventaMapper.toDTO(ventaGuardado);
        return ventaDTOConId;
    }

//    public double calcularComision(){
//        if(this.cantidadProductos <= 2){
//
//        }
//    }
}
