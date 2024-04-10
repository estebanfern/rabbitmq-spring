package org.estebanfern.rabbitmqcommons.dto.req;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CompraReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long productoId;
    private Integer cantidad;

}
