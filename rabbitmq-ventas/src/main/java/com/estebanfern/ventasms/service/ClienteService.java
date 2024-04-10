package com.estebanfern.ventasms.service;

import org.estebanfern.rabbitmqcommons.bean.Cliente;
import org.estebanfern.rabbitmqcommons.dto.req.ClienteReq;
import org.estebanfern.rabbitmqcommons.dto.req.CompraReq;

public interface ClienteService {
    Cliente save(ClienteReq clienteReq);
    void updateStock(CompraReq compraReq);
}
