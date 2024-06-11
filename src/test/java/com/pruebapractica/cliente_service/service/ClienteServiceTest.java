package com.pruebapractica.cliente_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pruebapractica.cliente_service.model.Cliente;
import com.pruebapractica.cliente_service.model.TipoDocumento;
import com.pruebapractica.cliente_service.repository.ClienteRepository;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClienteByTipoYNumeroDocumentoSuccess() {
        Cliente cliente = new Cliente();
        cliente.setTipoDocumento(new TipoDocumento(1L, "C", "Cédula de ciudadanía"));
        cliente.setNumeroDocumento("12345678");

        when(clienteRepository.findClienteByTipoYNumeroDocumento("C", "12345678")).thenReturn(cliente);

        Cliente result = clienteService.getClienteByTipoYNumeroDocumento("C", "12345678");
        assertEquals("C", result.getTipoDocumento().getCodigo());
        assertEquals("12345678", result.getNumeroDocumento());
    }

    @Test
    public void testGetClienteByTipoYNumeroDocumentoNotFound() {
        when(clienteRepository.findClienteByTipoYNumeroDocumento("C", "12345678")).thenReturn(null);

        Cliente result = clienteService.getClienteByTipoYNumeroDocumento("C", "12345678");
        assertNull(result);
    }

}
