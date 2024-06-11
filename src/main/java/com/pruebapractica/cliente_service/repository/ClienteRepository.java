package com.pruebapractica.cliente_service.repository;

import org.springframework.stereotype.Repository;

import com.pruebapractica.cliente_service.model.Ciudad;
import com.pruebapractica.cliente_service.model.Cliente;
import com.pruebapractica.cliente_service.model.TipoDocumento;

@Repository
public class ClienteRepository {

    public Cliente findClienteByTipoYNumeroDocumento(String codigo, String numeroDocumento) {
        if ("C".equals(codigo) && "23445322".equals(numeroDocumento)) {
            TipoDocumento tipoDocumento = new TipoDocumento(1L, "C", "Cédula de ciudadanía");
            Ciudad ciudad = new Ciudad(1L, "Bogotá");
            return new Cliente(1L, tipoDocumento, numeroDocumento, "Pepito", "Armando", "Perez", "Maradona", "3213136597", "Calle Falsa 123", ciudad);
        }
        return null;
    }

}
