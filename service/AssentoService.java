package com.example.demo.service;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.AssentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssentoService {
    @Autowired
    AssentoRepo assentoRepo;

    //obter lista de tdos Assento e lista de assentos por id
    //camada de baixo repository
    //camada de cima controllers/resource

    public List<Assento>findAll(){
       return assentoRepo.findAll();
    }
    public Assento findByid(Long id){
        Optional<Assento> obj = assentoRepo.findById(id);
        return obj.get();
    }


}
