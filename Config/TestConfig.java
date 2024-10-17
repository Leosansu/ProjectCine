package com.example.demo.Config;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Enum.Status;
import com.example.demo.Repository.AssentoRepo;
import com.example.demo.Repository.ClienteRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

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

        clienteRepo.saveAll(Arrays.asList(c1, c2, c3));

        Assento a = new Assento(null, "a",Status.Ocupado, c1);
        Assento b = new Assento(null, "b",Status.Ocupado, c2);
        Assento c = new Assento(null, "c",Status.Ocupado, c3);
        Assento d = new Assento(null, "d", Status.Livre);

        assentoRepo.saveAll(Arrays.asList(a, b, c, d));

        c1.setAssento(a);
        c2.setAssento(b);
        c3.setAssento(c);

        clienteRepo.saveAll(Arrays.asList(c1,c2,c3));


        // Associando o assento 'a' ao primeiro cliente
//        b.setCliente(clientes.get(1));  // Associando o assento 'b' ao segundo cliente
//        c.setCliente(clientes.get(2));  // Associando o assento 'c' ao terceiro cliente
//        d.setCliente(null);             // Assento livre não tem cliente associado


    }
}

