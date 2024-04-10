package com.estebanfern.ventasms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.estebanfern.rabbitmqcommons.bean.Transaccion;
import org.estebanfern.rabbitmqcommons.dto.req.VentaReq;

public interface VentaService {
    Transaccion save(VentaReq ventaReq) throws JsonProcessingException;
}
