package com.example.demo.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found. id "+ id +"/Recurso não encontrado. id: "+id);
    }
}
