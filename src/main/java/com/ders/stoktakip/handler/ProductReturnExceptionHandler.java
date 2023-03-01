package com.ders.stoktakip.handler;

import com.ders.stoktakip.exceptions.ProductReturnNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductReturnExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ProductReturnNotFoundException.class})
    protected ResponseEntity handleProductReturnException(ProductReturnNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
