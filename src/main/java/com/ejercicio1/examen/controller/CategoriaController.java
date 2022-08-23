package com.ejercicio1.examen.controller;

import com.ejercicio1.examen.DTO.CategoriaDTO;
import com.ejercicio1.examen.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?>crearProducto(@RequestBody CategoriaDTO categoriaDTO){ //le decimos con el @RequestBody que ProductoDto está viniendo del body
        return new ResponseEntity<>(categoriaService.save(categoriaDTO), HttpStatus.CREATED);
    }
}
