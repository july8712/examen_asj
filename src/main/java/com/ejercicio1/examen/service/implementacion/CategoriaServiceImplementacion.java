package com.ejercicio1.examen.service.implementacion;

import com.ejercicio1.examen.DTO.CategoriaDTO;
import com.ejercicio1.examen.entities.Categoria;
import com.ejercicio1.examen.mapper.CategoriaMapper;
import com.ejercicio1.examen.repository.CategoriaRepository;
import com.ejercicio1.examen.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImplementacion implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria categoriaGuardado = categoriaRepository.save(categoria);
        CategoriaDTO categoriaDTOConId = categoriaMapper.toDTO(categoriaGuardado);
        return categoriaDTOConId; //retornamos
    }
}
