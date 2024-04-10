package org.estebanfern.rabbitmqcommons.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class GenericException extends Exception {

    private String code;
    private int status;
    private Object data;

    public GenericException(String message, String code) {
        super(message);
        this.code = code;
        this.status = HttpStatus.BAD_REQUEST.value();
    }

    public GenericException(String message, String code, int status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public GenericException(String message, Throwable cause, String code, int status) {
        super(message, cause);
        this.code = code;
        this.status = status;
    }

    public GenericException(String message, String code, int status, Object data) {
        super(message);
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public GenericException(String message, Throwable cause, String code, int status, Object data) {
        super(message, cause);
        this.code = code;
        this.status = status;
        this.data = data;
    }

}
