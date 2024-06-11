package com.pruebapractica.cliente_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebapractica.cliente_service.model.Cliente;
import com.pruebapractica.cliente_service.service.IClienteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/cliente")
    public ResponseEntity<Cliente> getCliente(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento) {
        logger.info("Solicitud recibida para getCliente con tipoDocumento: {} y numeroDocumento: {}", tipoDocumento, numeroDocumento);
        try {
            if (tipoDocumento == null || tipoDocumento.isEmpty() || numeroDocumento == null || numeroDocumento.isEmpty()) {
                logger.warn("Bad request: tipoDocumento o numeroDocumento es nulo o vacio");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Cliente cliente = clienteService.getClienteByTipoYNumeroDocumento(tipoDocumento, numeroDocumento);
            if (cliente == null) {
                logger.warn("Cliente no encontrado para tipoDocumento: {} y numeroDocumento: {}", tipoDocumento, numeroDocumento);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            logger.debug("Cliente encontrado: {}", cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Interno del Servidor", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
