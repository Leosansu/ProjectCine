package com.example.demo.service;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.AssentoRepo;
import com.example.demo.service.exceptions.DatabaseException;
import com.example.demo.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
                new ResourceNotFoundException(id+" não encontrado"));
    }
    public Assento insert(Assento obj){
        return assentoRepo.save(obj);
    }
    public void delete(Long id){
        try{
            assentoRepo.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

    }
    public Assento upDate (Long id , Assento obj){
        Assento assentoEnti = assentoRepo.getReferenceById(id);
        updateData(assentoEnti,obj);
        return assentoRepo.save(assentoEnti);
    }

    private void updateData(Assento assentoEnti, Assento obj) {
        assentoEnti.setNome(obj.getNome());
        assentoEnti.setStatus(obj.getStatus());
    }

}
