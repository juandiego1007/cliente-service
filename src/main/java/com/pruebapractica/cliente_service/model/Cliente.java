package com.pruebapractica.cliente_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {

    private Long id;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private Ciudad ciudadResidencia;

    public Cliente() {}

    public Cliente(Long id, TipoDocumento tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String direccion, Ciudad ciudadResidencia) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
    }

}
