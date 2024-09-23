package com.example.E_mazon.domain.exception;

public class WrongQuantity extends RuntimeException {
    public WrongQuantity(String message) {
        super(message);
    }
}
