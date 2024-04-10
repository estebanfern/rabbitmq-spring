package org.estebanfern.rabbitmqcommons.dto.req;

import lombok.Data;

@Data
public class ProductoReq {
    private String nombre;
    private String descripcion;
    private Long precio;
}
