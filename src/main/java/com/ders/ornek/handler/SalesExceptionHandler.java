package com.ders.ornek.handler;

import com.ders.ornek.exceptions.SalesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SalesExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {SalesNotFoundException.class})
    protected ResponseEntity handleSalesException(SalesNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
