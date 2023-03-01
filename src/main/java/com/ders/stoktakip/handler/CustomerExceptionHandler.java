package com.ders.stoktakip.handler;

import com.ders.stoktakip.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomerNotFoundException.class})
    protected ResponseEntity handleCustomerException(CustomerNotFoundException ex) {
        
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
