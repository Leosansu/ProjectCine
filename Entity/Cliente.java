package com.example.demo.Entity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = (35))
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assento_id",unique = true)
    private Assento assento;

    public Cliente() {
    }


    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public Cliente(String nome) {
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
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
