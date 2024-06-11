package com.pruebapractica.cliente_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class TipoDocumento {

    private Long id;
    private String codigo;
    private String descripcion;

    public TipoDocumento(Long id, String codigo, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

}
