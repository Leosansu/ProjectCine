package com.example.demo.resource;

import com.example.demo.Entity.Assento;
import com.example.demo.service.AssentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/assentos")
public class AssentoResource {

    //obter uma lista de assentos
    //a camada de baixo é service é a de cima é a iteração com HTTP

    @Autowired
    AssentoService assentoService;

    @GetMapping
    public ResponseEntity<List<Assento>>findAll(){
        List<Assento>list = assentoService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <Assento> findById(@PathVariable Long id){
        Assento obj = assentoService.findByid(id);
        return ResponseEntity.ok().body(obj);
    }

}
