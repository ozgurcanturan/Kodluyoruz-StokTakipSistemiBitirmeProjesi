package com.ders.ornek.exceptions;

public class SalesNotFoundException extends RuntimeException {
    public SalesNotFoundException(String message) {
        super(message);
    }
}
