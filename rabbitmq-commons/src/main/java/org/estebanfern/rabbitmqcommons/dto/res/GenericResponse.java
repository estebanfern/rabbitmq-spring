package org.estebanfern.rabbitmqcommons.dto.res;

import lombok.Data;

@Data
public class GenericResponse<T> {

    private String message;
    private int status;
    private String code;
    private T data;

    public GenericResponse(String message, int status, String code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

    public GenericResponse(String message, int status, String code, T data) {
        this.message = message;
        this.status = status;
        this.code = code;
        this.data = data;
    }

    public static <W> GenericResponse<W> of(W data) {
        return new GenericResponse<W>(null, 200, null, data);
    }

}
