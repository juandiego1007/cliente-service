package com.pruebapractica.cliente_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebapractica.cliente_service.model.Cliente;
import com.pruebapractica.cliente_service.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente getClienteByTipoYNumeroDocumento(String codigo, String numeroDocumento) {
        return clienteRepository.findClienteByTipoYNumeroDocumento(codigo, numeroDocumento);
    }

}
