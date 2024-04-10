package org.estebanfern.rabbitmqcommons.dto.req;

import lombok.Data;

@Data
public class ClienteReq {
    private String nombre;
    private String correo;
    private String direccion;
}
