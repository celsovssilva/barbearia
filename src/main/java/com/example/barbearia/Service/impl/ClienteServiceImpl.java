package com.example.barbearia.Service.impl;

import org.springframework.stereotype.Service;

import com.example.barbearia.Model.ClienteModel;
import com.example.barbearia.Repository.ClienteRepository;
import com.example.barbearia.Service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;
    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteModel cadastroCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
        
    }

    @Override
    public ClienteModel buscarCliente(Long id) {
      return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
}
