package com.example.demo.service;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.ClienteRepo;
import com.example.demo.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepo clienteRepo;

    public List<Cliente> findAll(){
        return clienteRepo.findAll();
    }
    public Cliente findByid(Long id){
        Optional <Cliente> obj = clienteRepo.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id +" não encontrado") );

    }
    public Cliente insert(Cliente obj){
        return clienteRepo.save(obj);

    }
    public void delete(Long id){
        clienteRepo.deleteById(id);

    }
    public Cliente upDate(Long id , Cliente obj){
        Cliente clienteEnti = clienteRepo.getReferenceById(id);
        updateDate(clienteEnti,obj);
        return clienteRepo.save(clienteEnti);
    }

    private void updateDate(Cliente clienteEnti, Cliente obj) {
        clienteEnti.setNome(obj.getNome());
        clienteEnti.setAssento(obj.getAssento());
    }



}
