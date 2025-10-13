package com.example.barbearia.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;




public interface AgendamentoService {
  
    public BarbeiroModel buscarBarbeiroporNome(String nome);
    public List<AgendamentoModel> buscarAgendamentoDoDia(LocalDate dataInicio,LocalDate dataFim);
    public AgendamentoModel salvarAgendamento(AgendamentoModel agendamento);
    public void deletarAgendamento(Long id);

    
}
