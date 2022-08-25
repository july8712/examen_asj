package com.ejercicio1.examen.mapper;

import com.ejercicio1.examen.DTO.ProductoDTO;
import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.entities.ProductoEntity;
import com.ejercicio1.examen.entities.VentaEntity;
import com.ejercicio1.examen.repository.VendedorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class VentaMapper {
    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private VendedorMapper vendedorMapper;
    @Autowired
    private VendedorRepository vendedorRepository;

    public VentaEntity toEntity(VentaDTO ventaDTO){
        VentaEntity ventas = new VentaEntity();
        ventas.setCodigo(ventaDTO.getCodigo());
        return ventas;
    }
    //------------------------------------------------------------------
    public VentaDTO toDTO(VentaEntity ventaEntity){
        VentaDTO ventasDTO = new VentaDTO();
        ventasDTO.setCodigo(ventaEntity.getId());
        ventasDTO.setVendedorDTO(getVendedor(ventaEntity));
        ventasDTO.setProducto(getProductos(ventaEntity));

        return ventasDTO;
    }

    public VendedorDTO getVendedor(VentaEntity ventaEntity){
        VendedorDTO vendedorDTO = vendedorMapper.toDTO(ventaEntity.getVendedor());
        double comision = 0;
        double totalVentas = 0;
        if(ventaEntity.getProducto().size() > 2){
            for (ProductoEntity precioProducto : ventaEntity.getProducto()) {
                totalVentas += precioProducto.getPrecio();
            }
            comision = totalVentas * 0.10;
        }else if(ventaEntity.getProducto().size() > 0 && ventaEntity.getProducto().size() <= 2){
            for (ProductoEntity precioProducto : ventaEntity.getProducto()) {
                totalVentas += precioProducto.getPrecio();
            }
            comision = totalVentas * 0.05;
        }
        vendedorDTO.setComision(comision);
        vendedorDTO.setSueldoTotal( ventaEntity.getVendedor().getSueldo() + comision);
        return vendedorDTO;
    }

    public Set<ProductoDTO> getProductos(VentaEntity ventaEntity){
        return productoMapper.setProductoDTO(ventaEntity.getProducto());
    }

    //---------------------------------------------------------------------
    public List<VentaDTO> toListDTO(List<VentaEntity> list){
        List<VentaDTO> lista = new ArrayList<>();

        for (VentaEntity ventaEntity : list) {
            lista.add(toDTO(ventaEntity));
        }

        return lista;
    }

    public VentaDTO obtenerVentaDTO(VentaEntity ventaEntity){
        VentaDTO ventaDTO = toDTO(ventaEntity);
        ventaDTO.setProducto(setProductoDTO(ventaEntity.getProducto()));
        return  ventaDTO;
    }

    public Set<ProductoDTO> setProductoDTO(Set<ProductoEntity> productoEntitySet){
        return productoMapper.setProductoDTO(productoEntitySet);
    }
}
