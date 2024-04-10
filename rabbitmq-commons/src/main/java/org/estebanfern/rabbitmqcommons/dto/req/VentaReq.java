package org.estebanfern.rabbitmqcommons.dto.req;

import lombok.Data;

@Data
public class VentaReq {
    private Long clienteId;
    private Long productoId;
    private int cantidad;
    private Long precioTotal;
}
