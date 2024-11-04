package com.example.demo.resource;

import com.example.demo.Entity.Assento;
import com.example.demo.service.AssentoService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/assentos")
public class AssentoResource {

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
    @PostMapping
    public ResponseEntity <Assento> insert (@RequestBody Assento obj){
        obj = assentoService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Assento obj = assentoService.findByid(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        assentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Assento> update (@PathVariable Long id,@RequestBody Assento obj){
        obj = assentoService.upDate(id,obj);
        return ResponseEntity.ok().body(obj);

    }


}
