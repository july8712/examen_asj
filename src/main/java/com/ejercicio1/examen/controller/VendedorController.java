package com.ejercicio1.examen.controller;

import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<?> crearVendedor(@RequestBody VendedorDTO vendedorDTO){ //le decimos con el @RequestBody que ProductoDto está viniendo del body
        return new ResponseEntity<>(vendedorService.save(vendedorDTO), HttpStatus.CREATED);
    }
}
