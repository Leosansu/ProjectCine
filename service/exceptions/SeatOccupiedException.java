package com.example.demo.service.exceptions;

public class SeatOccupiedException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public SeatOccupiedException(String msg) {
        super(msg);
    }
}

