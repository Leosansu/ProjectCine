package com.example.demo.Repository;

import com.example.demo.Entity.Assento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssentoRepo extends JpaRepository<Assento,Long> {
    Assento findByNome (String nome);

}
