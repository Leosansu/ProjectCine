package com.example.demo.resource;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/Cliente")
public class ClienteResource {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>>findAll(){
        List<Cliente> clienteList = clienteService.findAll();
        return ResponseEntity.ok().body(clienteList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <Cliente> findById(@PathVariable Long id){
        Cliente obj = clienteService.findByid(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity <Cliente> insert (@RequestBody Cliente obj){
        obj = clienteService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Cliente obj = clienteService.findByid(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping(value = "/{clienteId}/assentos/{assentoId}")
    public ResponseEntity<Cliente> relacionarAssento(@PathVariable Long clienteId, @PathVariable Long assentoId) {
        Cliente cliente = clienteService.reservaAssento(clienteId, assentoId);
        return ResponseEntity.ok().body(cliente);
    }//refazer esse método linha por linha, e refazaer o tratamento de exceções

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update (@PathVariable Long id,@RequestBody Cliente obj){
        obj = clienteService.upDate(id,obj);
        return ResponseEntity.ok().body(obj);
    }

}
