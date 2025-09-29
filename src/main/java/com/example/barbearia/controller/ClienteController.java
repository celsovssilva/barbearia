package com.example.barbearia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.barbearia.Model.ClienteModel;
import com.example.barbearia.Repository.ClienteRepository;
import com.example.barbearia.Service.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;
    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository){
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/cadastrar")
    public ClienteModel cadastrarClienteModel(@RequestBody ClienteModel clienteModel){ {
       return clienteService.cadastroCliente(clienteModel);
        
    
    }}
    

    @GetMapping("/buscar/{id}")
    public ClienteModel buscarCliente(Long id){
        return clienteService.buscarCliente(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(long id){
        clienteService.deletar(id);
    }
    
    
    
}
