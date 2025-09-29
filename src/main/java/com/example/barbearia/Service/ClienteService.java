package com.example.barbearia.Service;

import org.springframework.stereotype.Service;

import com.example.barbearia.Model.ClienteModel;
import com.example.barbearia.Repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    public ClienteService( ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
        
    }

    public ClienteModel cadastroCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public ClienteModel buscarCliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }
    public void deletar(long id){
        clienteRepository.deleteById(id);
    }

}
