package com.example.demo.Repository;

import com.example.demo.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Long> {
    //List<Cliente> findByNome(String nome);
}
