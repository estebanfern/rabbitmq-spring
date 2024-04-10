package org.estebanfern.rabbitmqcommons.utils;

import org.estebanfern.rabbitmqcommons.bean.Cliente;
import org.estebanfern.rabbitmqcommons.dto.req.ClienteReq;

public class ClienteUtils {

    public static Cliente clienteFromRequest(ClienteReq clienteReq) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteReq.getNombre());
        cliente.setCorreo(clienteReq.getCorreo());
        cliente.setDireccion(clienteReq.getDireccion());
        return cliente;
    }

}
