package com.example.demo.dto;

import com.example.demo.Entity.Assento;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


public class ClienteDto implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Assento assento;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;

    }
    public ClienteDto(String nome) {
        this.nome = nome;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteDto cliente)) return false;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
