package org.estebanfern.rabbitmqcommons.bean;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Transaccion {
    private Long id;
    private TipoTransaccion tipo;
    private OffsetDateTime fecha;
    private Long clienteId;
    private Long productoId;
    private int cantidad;
    private Long precioTotal;
}
