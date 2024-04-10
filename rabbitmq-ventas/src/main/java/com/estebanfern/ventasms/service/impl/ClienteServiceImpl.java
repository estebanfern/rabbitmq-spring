package com.estebanfern.ventasms.service.impl;

import com.estebanfern.ventasms.dao.ClienteDao;
import com.estebanfern.ventasms.service.ClienteService;
import lombok.AllArgsConstructor;
import org.estebanfern.rabbitmqcommons.bean.Cliente;
import org.estebanfern.rabbitmqcommons.dto.req.ClienteReq;
import org.estebanfern.rabbitmqcommons.dto.req.CompraReq;
import org.estebanfern.rabbitmqcommons.utils.ClienteUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteDao clienteDao;

    @Override
    public Cliente save(ClienteReq clienteReq) {
        Cliente cliente = ClienteUtils.clienteFromRequest(clienteReq);
        clienteDao.save(cliente);
        return cliente;
    }

    @Override
    public void updateStock(CompraReq compraReq) {

    }
}
