package com.example.E_mazon.infrastructure.exception;

public class FeignConnectionError extends RuntimeException {
    public FeignConnectionError(String message) {
        super(message);
    }
}
