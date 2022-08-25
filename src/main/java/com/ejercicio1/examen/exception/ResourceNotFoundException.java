package com.ejercicio1.examen.exception;

import org.springframework.web.util.NestedServletException;

public class ResourceNotFoundException extends NestedServletException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    } //todas las excepciones con este nombre las manda acá
}


