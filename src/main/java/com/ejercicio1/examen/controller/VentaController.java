package com.ejercicio1.examen.controller;

import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.exception.ResourceNotFoundException;
import com.ejercicio1.examen.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:4200")
public class VentaController {


    @Autowired
    private VentaService ventasService;

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody VentaDTO ventaDTO){
        ventasService.crearVentas(ventaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> obtenerVentas() throws ResourceNotFoundException {
        return new ResponseEntity<>(ventasService.obtenerVentas(), HttpStatus.OK);
    }

    @PostMapping("/{id}/producto")
    public ResponseEntity<?> agregarProductoAVentas(@PathVariable Long id, @RequestBody List<Long> productosId) throws ResourceNotFoundException {
        return new ResponseEntity<>(ventasService.agregarProductoAVenta(id, productosId), HttpStatus.CREATED);
    }

    @GetMapping("/palabra")
    public ResponseEntity<?> findByProductoByCategoriaContaining(@RequestParam String word){
        return new ResponseEntity<>( ventasService.findByProductoByCategoriaContaining(word), HttpStatus.OK);
    }



}
