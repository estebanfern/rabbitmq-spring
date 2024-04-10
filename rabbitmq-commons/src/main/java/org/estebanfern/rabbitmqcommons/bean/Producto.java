package org.estebanfern.rabbitmqcommons.bean;

import lombok.Data;

@Data
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long precio;
    private int stock;
}
