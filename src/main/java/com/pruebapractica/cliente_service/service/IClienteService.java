package com.pruebapractica.cliente_service.service;

import com.pruebapractica.cliente_service.model.Cliente;

public interface IClienteService {

    public Cliente getClienteByTipoYNumeroDocumento(String codigo, String numeroDocumento);

}
