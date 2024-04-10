package com.estebanfern.productosms.controller.api;

import com.estebanfern.productosms.service.ProductoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.estebanfern.rabbitmqcommons.bean.Producto;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dto.req.ProductoReq;
import org.estebanfern.rabbitmqcommons.dto.req.CompraReq;
import org.estebanfern.rabbitmqcommons.dto.res.GenericResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/productos")
@AllArgsConstructor
public class ProductosApi {

    private ProductoService productoService;

    @PostMapping
    public GenericResponse<Producto> createProducto(@RequestBody @Valid ProductoReq productoReq) {
        return GenericResponse.of(
            productoService.save(productoReq)
        );
    }

    @PutMapping
    public GenericResponse<Transaccion> updateProducto(@RequestBody @Valid CompraReq compraReq) throws JsonProcessingException {
        return GenericResponse.of(
            productoService.addStock(compraReq)
        );
    }

}
