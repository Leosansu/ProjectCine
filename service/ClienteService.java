package com.example.demo.service;

import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.ClienteRepo;
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
        return obj.get();

    }


}
