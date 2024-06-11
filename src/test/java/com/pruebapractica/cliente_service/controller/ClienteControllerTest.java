package com.pruebapractica.cliente_service.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.pruebapractica.cliente_service.model.Cliente;
import com.pruebapractica.cliente_service.model.TipoDocumento;
import com.pruebapractica.cliente_service.service.IClienteService;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClienteService clienteService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClienteSuccess() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setTipoDocumento(new TipoDocumento(1L, "C", "Cédula de ciudadanía"));
        cliente.setNumeroDocumento("12345678");

        when(clienteService.getClienteByTipoYNumeroDocumento("C", "12345678")).thenReturn(cliente);

        mockMvc.perform(get("/cliente")
                .param("tipoDocumento", "C")
                .param("numeroDocumento", "12345678"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetClienteNotFound() throws Exception {
        when(clienteService.getClienteByTipoYNumeroDocumento("C", "12345678")).thenReturn(null);

        mockMvc.perform(get("/cliente")
                .param("tipoDocumento", "C")
                .param("numeroDocumento", "12345678"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetClienteBadRequest() throws Exception {
        mockMvc.perform(get("/cliente")
                .param("tipoDocumento", "")
                .param("numeroDocumento", "12345678"))
                .andExpect(status().isBadRequest());

        mockMvc.perform(get("/cliente")
                .param("tipoDocumento", "C")
                .param("numeroDocumento", ""))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetClienteInternalServerError() throws Exception {
        when(clienteService.getClienteByTipoYNumeroDocumento("C", "12345678")).thenThrow(new RuntimeException());

        mockMvc.perform(get("/cliente")
                .param("tipoDocumento", "C")
                .param("numeroDocumento", "12345678"))
                .andExpect(status().isInternalServerError());
    }

}
