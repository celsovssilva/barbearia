package com.example.barbearia.Service;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;



public interface AgendamentoService {
  
    public BarbeiroModel buscarBarbeiroporNome(String nome);
    public AgendamentoModel salvarAgendamento(AgendamentoModel agendamento);
    public void deletarAgendamento(Long id);

    
}
