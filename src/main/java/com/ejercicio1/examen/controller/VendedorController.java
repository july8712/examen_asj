package com.ejercicio1.examen.controller;

import com.ejercicio1.examen.DTO.VendedorDTO;
import com.ejercicio1.examen.exception.ResourceNotFoundException;
import com.ejercicio1.examen.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendedor")
@CrossOrigin(origins = "http://localhost:4200")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<?> crearVendedor(@RequestBody VendedorDTO vendedorDTO){ //le decimos con el @RequestBody que ProductoDto está viniendo del body
        return new ResponseEntity<>(vendedorService.crearVendedor(vendedorDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> obtenerVendero() throws ResourceNotFoundException {
        return new ResponseEntity<>(vendedorService.obtenerVendedores(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedorDTO) throws ResourceNotFoundException {
        return new ResponseEntity<>(vendedorService.actualizarVendedor(id, vendedorDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable Long id) throws ResourceNotFoundException {
        vendedorService.eliminarVendedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
