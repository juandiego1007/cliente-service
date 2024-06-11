package com.pruebapractica.cliente_service.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.pruebapractica.cliente_service.model.Cliente;

public class ClienteRepositoryTest {

    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setup() {
        clienteRepository = new ClienteRepository();
    }

    @Test
    public void testFindClienteByTipoYNumeroDocumentoSuccess() {
        String codigo = "C";
        String numeroDocumento = "23445322";

        Cliente result = clienteRepository.findClienteByTipoYNumeroDocumento(codigo, numeroDocumento);

        assertEquals("C", result.getTipoDocumento().getCodigo());
        assertEquals("23445322", result.getNumeroDocumento());
        assertEquals("Pepito", result.getPrimerNombre());
        assertEquals("Armando", result.getSegundoNombre());
        assertEquals("Perez", result.getPrimerApellido());
        assertEquals("Maradona", result.getSegundoApellido());
        assertEquals("3213136597", result.getTelefono());
        assertEquals("Calle Falsa 123", result.getDireccion());
        assertEquals("Bogotá", result.getCiudadResidencia().getNombre());
    }

    @Test
    public void testFindClienteByTipoYNumeroDocumentoNotFound() {
        String codigo = "X";
        String numeroDocumento = "00000000";
        Cliente result = clienteRepository.findClienteByTipoYNumeroDocumento(codigo, numeroDocumento);
        assertNull(result);
    }
}
