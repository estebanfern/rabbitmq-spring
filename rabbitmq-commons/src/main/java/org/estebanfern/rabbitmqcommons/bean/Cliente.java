package org.estebanfern.rabbitmqcommons.bean;

import lombok.Data;

@Data
public class Cliente {
    private Long id;
    private String nombre;
    private String correo;
    private String direccion;
}
