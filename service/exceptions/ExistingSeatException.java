package com.example.demo.service.exceptions;

public class ExistingSeatException extends RuntimeException{
    private static final Long serialVersionUID = 1L;


    public ExistingSeatException(String msg) {
        super("Não pode haver dois assentos iguais");
    }

}
