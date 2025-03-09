package com.example.demo.resource;

import com.example.demo.Entity.Assento;
import com.example.demo.dto.AssentoDto;
import com.example.demo.service.AssentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/assentos")
public class AssentoResource {

    @Autowired
    private AssentoService assentoService;

    @Autowired
    private ModelMapper modelMapper ;



    @GetMapping
    public ResponseEntity<List<AssentoDto>> findAll() {
        List<AssentoDto> list = assentoService.findAll();
        List<AssentoDto> dtoList = list.stream()
                .map(assento -> modelMapper.map(assento, AssentoDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AssentoDto> findById(@PathVariable Long id) {
        AssentoDto obj = assentoService.findByid(id);
        AssentoDto dto = modelMapper.map(obj, AssentoDto.class);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping
    public ResponseEntity <AssentoDto> insert (@RequestBody AssentoDto obj){
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
        AssentoDto obj = assentoService.findByid(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        assentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AssentoDto> update (@PathVariable Long id,@RequestBody AssentoDto obj){
        obj = assentoService.upDate(id,obj);
        return ResponseEntity.ok().body(obj);

    }

}