package com.example.barbearia.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;
import com.example.barbearia.Repository.AgendamentoRepository;
import com.example.barbearia.Service.AgendamentoService;


@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoController(AgendamentoService agendamentoService,AgendamentoRepository agendamentoRepository){
        this.agendamentoService= agendamentoService;
        this.agendamentoRepository = agendamentoRepository;
    }

    @PostMapping("/agendamento")
    public AgendamentoModel salvarAgendamento(@RequestBody AgendamentoModel agendamentoModel){
        return agendamentoService.salvarAgendamento(agendamentoModel);
        
    }

    @GetMapping("/buscar/{nome}")
    public List<BarbeiroModel> buscarBarbeiroporNome(@PathVariable String nome){
        return (List<BarbeiroModel>) agendamentoService.buscarBarbeiroporNome(nome);
    }
    
    @DeleteMapping("/deletarbarbeiro/{id}")
     public void deletarAgendamento(Long id){
    agendamentoService.deletarAgendamento(id);}

    

    
    
}
