package com.estebanfern.ventasms.controller.advicer;

import org.estebanfern.rabbitmqcommons.dto.res.GenericResponse;
import org.estebanfern.rabbitmqcommons.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestAdvicer {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<GenericResponse<Void>> globalHandler(Throwable e) {
        return ResponseEntity.badRequest().body(
            new GenericResponse<>(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name()
            )
        );
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericResponse<Object>> handleGenericException(GenericException e) {
        return ResponseEntity.badRequest().body(
            new GenericResponse<>(
                e.getMessage(),
                e.getStatus(),
                e.getCode(),
                e.getData()
            )
        );
    }

}
