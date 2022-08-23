package com.ejercicio1.examen.controller;

import com.ejercicio1.examen.DTO.ProductoDTO;
import com.ejercicio1.examen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<?>crearProducto(@RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(productoService.save(productoDTO), HttpStatus.CREATED);
    }
}
