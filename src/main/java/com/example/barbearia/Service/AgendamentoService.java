package com.example.barbearia.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;




public interface AgendamentoService {
  
    public BarbeiroModel buscarBarbeiroporNome(String nome);
    public List<AgendamentoModel> buscarAgendamentoDoDia(LocalDateTime dataHora,LocalDateTime dataHoraFim);
    public AgendamentoModel salvarAgendamento(AgendamentoModel agendamento);
    public void deletarAgendamento(Long id);

    
}
