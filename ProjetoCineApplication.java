package com.example.demo;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Status;
import com.example.demo.Repository.AssentoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoCineApplication implements CommandLineRunner {
	@Autowired
	AssentoRepo assentoRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoCineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String nome = "E";

		Assento assento = assentoRepo.findByNome(nome);
		assento.setNome("D");
		assentoRepo.save(assento);


	}
}
