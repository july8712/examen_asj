package com.ejercicio1.examen.repository;

import com.ejercicio1.examen.entities.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntity, Long> {
}
