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


        Cliente c1 = new Cliente("Ana");
        Cliente c2 = new Cliente("Biel");
        Cliente c3 = new Cliente("Le");
        Cliente c4 = new Cliente("Juju");

        clienteRepo.saveAll(Arrays.asList(c1, c2, c3,c4));

        Assento a = new Assento(null, "a",Status.valueOfIgnoreCase("Ocupado"), c1);
        Assento b = new Assento(null, "b",Status.valueOfIgnoreCase("OCUpADO"), c2);
        Assento c = new Assento(null, "c",Status.valueOfIgnoreCase("Ocupado"), c3);
        Assento d = new Assento(null, "d",Status.valueOfIgnoreCase("Livre"));
        Assento e = new Assento(null, "e",Status.valueOfIgnoreCase("LIVRE"));

        assentoRepo.saveAll(Arrays.asList(a, b, c, d,e));

        c1.setAssento(a);
        c2.setAssento(b);
        c3.setAssento(c);

        clienteRepo.saveAll(Arrays.asList(c1,c2,c3));

    }
}

