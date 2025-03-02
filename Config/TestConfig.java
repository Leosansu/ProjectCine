package com.example.demo.Config;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Enum.Status;
import com.example.demo.Repository.AssentoRepo;
import com.example.demo.Repository.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired

    AssentoRepo assentoRepo;
    @Autowired
    ClienteRepo clienteRepo;

    @Override
    public void run(String... args) throws Exception {


        Assento a = new Assento(null, "a", Status.valueOfIgnoreCase("Livre"));
        Assento b = new Assento(null, "b", Status.valueOfIgnoreCase("Livre"));
        Assento c = new Assento(null, "c", Status.valueOfIgnoreCase("Livre"));
        Assento d = new Assento(null, "d", Status.valueOfIgnoreCase("Livre"));
        Assento e = new Assento(null, "e", Status.valueOfIgnoreCase("LIVRE"));

        assentoRepo.saveAll(Arrays.asList(a, b, c, d, e));




    }
}

