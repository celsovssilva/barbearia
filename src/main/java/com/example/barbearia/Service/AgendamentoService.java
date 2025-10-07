package com.example.barbearia.Service;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;
import com.example.barbearia.Model.ClienteModel;
import java.time.LocalDateTime;




public interface AgendamentoService {
  
    public BarbeiroModel buscarBarbeiroporNome(String nome);
    public AgendamentoModel buscarAgendamentoDoDia(LocalDateTime dataHora,LocalDateTime dataHoraFim);
    public AgendamentoModel salvarAgendamento(AgendamentoModel agendamento);
    public void deletarAgendamento(Long id);

    
}
