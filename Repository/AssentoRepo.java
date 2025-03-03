package com.example.demo.Repository;

import com.example.demo.Entity.Assento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssentoRepo extends JpaRepository<Assento,Long> {
    Optional<Assento> findByNome(String nome);

}
