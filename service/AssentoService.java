package com.example.demo.service;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.AssentoRepo;
import com.example.demo.dto.AssentoDto;
import com.example.demo.service.exceptions.DatabaseException;
import com.example.demo.service.exceptions.ExistingSeatException;
import com.example.demo.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssentoService {
    @Autowired
    AssentoRepo assentoRepo;

    @Autowired
    ModelMapper modelMapper;



    public List<AssentoDto> findAll() {
        List<Assento> assentos = assentoRepo.findAll();
        return assentos.stream()
                .map(assento -> modelMapper.map(assento, AssentoDto.class))
                .collect(Collectors.toList());
    }

    public AssentoDto findByid(Long id) {
        Assento assento = assentoRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id + " não encontrado"));
        return modelMapper.map(assento, AssentoDto.class);
    }
    public AssentoDto insert(AssentoDto dtoObj) {
        if (assentoRepo.findByNome(dtoObj.getNome()).isPresent()) {
            throw new ExistingSeatException("Assento " + dtoObj.getNome() + " já existe");
        }
        Assento assento = modelMapper.map(dtoObj, Assento.class);
        assento = assentoRepo.save(assento);
        return modelMapper.map(assento, AssentoDto.class);
    }

    public void delete(Long id) {
        try {
            assentoRepo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public AssentoDto upDate(Long id, AssentoDto dtoObj) {
        Assento assentoEnti = assentoRepo.getReferenceById(id);
        updateData(assentoEnti, dtoObj);
        assentoEnti = assentoRepo.save(assentoEnti);
        return modelMapper.map(assentoEnti, AssentoDto.class);
    }

    private void updateData(Assento assentoEnti, AssentoDto dtoObj) {
        assentoEnti.setNome(dtoObj.getNome());
        assentoEnti.setStatus(dtoObj.getStatus());
    }
}
