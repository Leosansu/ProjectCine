package com.example.demo.service;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.AssentoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssentoService {
    @Autowired
    AssentoRepo assentoRepo;


    public List<Assento> findAll() {
        return assentoRepo.findAll();
    }

    public Assento findByid(Long id) {
        return assentoRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Assento não encontrado" + id) );
    }
    public Assento insert(Assento obj){
        return assentoRepo.save(obj);
    }
    public void delete(Long id){
        assentoRepo.deleteById(id);

    }



}
