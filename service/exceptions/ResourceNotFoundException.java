package com.example.demo.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("id not found :"+id);
    }
}
