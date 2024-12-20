package com.example.demo.service;

import com.example.demo.Entity.Assento;
import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Enum.Status;
import com.example.demo.Repository.AssentoRepo;
import com.example.demo.Repository.ClienteRepo;
import com.example.demo.service.exceptions.ResourceNotFoundException;
import com.example.demo.service.exceptions.SeatOccupiedException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    AssentoRepo assentoRepo;

    public List<Cliente> findAll(){
        return clienteRepo.findAll();
    }
    public Cliente findByid(Long id){
        Optional <Cliente> obj = clienteRepo.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id +" não encontrado") );

    }
    public Cliente insert(Cliente obj){
        return clienteRepo.save(obj);
    }

    @Transactional
    public void deletarCliente(Long id) {
        // Obter o cliente pelo ID
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        Assento assento = cliente.getAssento(); // Obter o assento do cliente

        if (assento != null) {
            assento.setStatus(Status.Livre); // Altera o status do assento
            assentoRepo.save(assento); // Atualiza o assento no banco
        }
        clienteRepo.delete(cliente); // Deleta o cliente
    }

    public Cliente upDate(Long id , Cliente obj){
        Cliente clienteEnti = clienteRepo.getReferenceById(id);
        updateDate(clienteEnti,obj);
        return clienteRepo.save(clienteEnti);
    }

    private void updateDate(Cliente clienteEnti, Cliente obj) {
        clienteEnti.setNome(obj.getNome());
        clienteEnti.setAssento(obj.getAssento());
    }
    public Cliente reservaAssento(Long clienteId,Long assentoId){
        Cliente cliente = clienteRepo.findById(clienteId).orElseThrow(()->new ResourceNotFoundException("Cliente não encontrado com id: "+clienteId));
        Assento assento = assentoRepo.findById(assentoId).orElseThrow(()-> new ResourceNotFoundException("Assento não encontrado com id:"+assentoId));

        if(assento.getStatus() == Status.Livre ){
            assento.setStatus(Status.Ocupado);
            assentoRepo.save(assento);
            cliente.setAssento(assento);
            clienteRepo.save(cliente);

        }else {
            throw new SeatOccupiedException("Assento com id: "+assentoId+ ", está ocupado.");

        }return cliente;
    }
}
