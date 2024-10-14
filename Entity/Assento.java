package com.example.demo.Entity;

import com.example.demo.Entity.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter

public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Assento", nullable = false, unique = true, length = 2)
    private String nome;

    private Integer status;

    @JsonIgnore
    @OneToOne(mappedBy = "assento")

    private Cliente cliente;

    public Cliente getCliente(){
        return cliente;

    }

    public Assento() {
    }

    public Assento(String nome, Status status, Cliente cliente) {
        this.nome = nome;
        setStatus(status);
        this.cliente = cliente;
    }

    public Assento(String nome, Status status) {
        this.nome = nome;
        setStatus(status);
    }

    public Assento(Long id, String nome, Status status, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        setStatus(status);
        this.cliente = cliente;
    }

    public Status getStatus() {
        return Status.valueOff(status);
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getCode();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assento assento)) return false;
        return Objects.equals(id, assento.id) && Objects.equals(nome, assento.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}


