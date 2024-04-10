package com.estebanfern.ventasms.controller.api;

import com.estebanfern.ventasms.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.estebanfern.rabbitmqcommons.bean.Cliente;
import org.estebanfern.rabbitmqcommons.dto.req.ClienteReq;
import org.estebanfern.rabbitmqcommons.dto.req.VentaReq;
import org.estebanfern.rabbitmqcommons.dto.res.GenericResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
@AllArgsConstructor
public class ClientesApi {

    private ClienteService clienteService;

    @PostMapping
    public GenericResponse<Cliente> createCliente(@RequestBody @Valid ClienteReq clienteReq) {
        return GenericResponse.of(
            clienteService.save(clienteReq)
        );
    }

}
