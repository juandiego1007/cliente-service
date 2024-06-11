package com.pruebapractica.cliente_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Ciudad {

    private Long id;
    private String nombre;

    public Ciudad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

}
