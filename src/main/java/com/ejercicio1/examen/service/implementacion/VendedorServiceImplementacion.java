package com.ejercicio1.examen.service.implementacion;

import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.entities.VendedorEntity;
import com.ejercicio1.examen.exception.ResourceNotFoundException;
import com.ejercicio1.examen.mapper.VendedorMapper;
import com.ejercicio1.examen.repository.VendedorRepository;
import com.ejercicio1.examen.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorServiceImplementacion implements VendedorService {

    private final VendedorMapper vendedorMapper;
    private final VendedorRepository vendedorRepository;

    @Autowired
    public VendedorServiceImplementacion(VendedorMapper vendedorMapper,
                               VendedorRepository vendedorRepository){
        this.vendedorMapper = vendedorMapper;
        this.vendedorRepository = vendedorRepository;
    }
    @Override
    public VendedorDTO crearVendedor(VendedorDTO vendedorDTO) {
        VendedorEntity vendedorEntity = vendedorMapper.toEntity(vendedorDTO);
        VendedorEntity vendedorGuardado = vendedorRepository.save(vendedorEntity);
        VendedorDTO vendedorARetornar = vendedorMapper.toDTO(vendedorGuardado);

        return vendedorARetornar;
    }

    @Override
    public List<VendedorDTO> obtenerVendedores() throws ResourceNotFoundException {
        List<VendedorEntity> listaVendedores = vendedorRepository.findAll();
        if(listaVendedores.isEmpty()){
            throw new ResourceNotFoundException("Lista vacia");
        }

        List<VendedorDTO> listaVendedoresARetornar = vendedorMapper.toListDTO(listaVendedores);

        return listaVendedoresARetornar;
    }

    @Override
    public VendedorDTO actualizarVendedor(Long id, VendedorDTO vendedorDTO) throws ResourceNotFoundException {
        VendedorEntity vendedorEntity = vendedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        VendedorEntity vendedorActualizado = vendedorMapper.toSet(vendedorEntity, vendedorDTO);
        VendedorEntity vendedor = vendedorRepository.save(vendedorActualizado);
        VendedorDTO vendedorDTO1 = vendedorMapper.toDTO(vendedor);

        return vendedorDTO1;
    }

    @Override
    public void eliminarVendedor(Long id) throws ResourceNotFoundException {
        vendedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe el id: " + id)
        );
        vendedorRepository.deleteById(id);
    }
}
