package com.ejercicio1.examen.repository;

import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.entities.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
    List<VentaEntity> findByProductoCategoriaContaining(String word);
}
