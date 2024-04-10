package com.estebanfern.ventasms.controller.api;

import com.estebanfern.ventasms.service.VentaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dto.req.VentaReq;
import org.estebanfern.rabbitmqcommons.dto.res.GenericResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ventas")
@AllArgsConstructor
public class VentasApi {

    private VentaService ventaService;

    @PostMapping
    public GenericResponse<Transaccion> createCliente(@RequestBody @Valid VentaReq ventaReq) throws JsonProcessingException {
        return GenericResponse.of(
            ventaService.save(ventaReq)
        );
    }

}
