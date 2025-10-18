package com.example.barbearia.Service;

import org.springframework.stereotype.Service;

import com.example.barbearia.Model.ClienteModel;


@Service
public interface  ClienteService {
    ClienteModel cadastroCliente(ClienteModel cliente);
    ClienteModel buscarCliente(Long id);
    void deletarCliente(Long id);

}
