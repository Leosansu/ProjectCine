package com.example.demo.dto;

import com.example.demo.Entity.Enum.Status;

import java.io.Serializable;
import java.util.Objects;

public class AssentoDto implements Serializable {
    public static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private Status status;
    private ClienteDto cliente;

    public AssentoDto() {
    }

    public AssentoDto(Long id, String nome, Status status, ClienteDto cliente) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.cliente = cliente;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssentoDto that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(status, that.status) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, status, cliente);
    }
}