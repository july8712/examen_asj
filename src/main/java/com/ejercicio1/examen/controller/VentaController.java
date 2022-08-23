package com.ejercicio1.examen.controller;

import com.ejercicio1.examen.DTO.VentaDTO;
import com.ejercicio1.examen.service.VendedorService;
import com.ejercicio1.examen.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody VentaDTO ventaDTO){ //le decimos con el @RequestBody que ProductoDto está viniendo del body
        return new ResponseEntity<>(ventaService.save(ventaDTO), HttpStatus.CREATED);
    }
}
