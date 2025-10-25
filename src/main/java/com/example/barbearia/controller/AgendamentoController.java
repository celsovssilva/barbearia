package com.example.barbearia.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<AgendamentoModel> salvarAgendamento(@RequestBody AgendamentoModel agendamentoModel) {
        AgendamentoModel agendamentoSalvo = agendamentoService.salvarAgendamento(agendamentoModel);
        return ResponseEntity.ok(agendamentoSalvo);
    }

    @GetMapping("/barbeiro/{nome}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<BarbeiroModel> buscarBarbeiroPorNome(@PathVariable String nome) {
        BarbeiroModel barbeiro = agendamentoService.buscarBarbeiroporNome(nome);
        return ResponseEntity.ok(barbeiro);
    }

    @PutMapping("atualizar/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<AgendamentoModel> atualizarAgendamento(
            @PathVariable Long id,
            @RequestBody AgendamentoModel agendamento) {
        AgendamentoModel agendamentoAtualizado = agendamentoService.atualizarAgendamento(id, agendamento);
        return ResponseEntity.ok(agendamentoAtualizado);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id) {
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
    

    
    
}
