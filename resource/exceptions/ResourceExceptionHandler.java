package com.example.demo.resource.exceptions;

import com.example.demo.service.exceptions.DatabaseException;
import com.example.demo.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity <StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "/Resource not found/Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError erro = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(erro);

    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request) {
        String error = "/Database error/Erro no banco de dados";  //definindo msg de erro
        HttpStatus status = HttpStatus.BAD_REQUEST;                     //definindo o status de resposta
        StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(erro);
    }
}
