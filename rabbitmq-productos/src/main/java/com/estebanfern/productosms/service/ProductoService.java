package com.estebanfern.productosms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.estebanfern.rabbitmqcommons.bean.Producto;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dto.req.ProductoReq;
import org.estebanfern.rabbitmqcommons.dto.req.CompraReq;

public interface ProductoService {
    Producto save(ProductoReq productoReq);
    Transaccion addStock(CompraReq compraReq) throws JsonProcessingException;

    void sendTransaccion(Transaccion transaccion) throws JsonProcessingException;
}
