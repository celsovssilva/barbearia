package com.example.barbearia.Service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;
import com.example.barbearia.Repository.AgendamentoRepository;
import com.example.barbearia.Repository.BarbeiroRepository;
import com.example.barbearia.Service.AgendamentoService;

@Service
public class AgendamentoServiceImpl implements  AgendamentoService{

    private final BarbeiroRepository barbeiroRepository;
    private final AgendamentoRepository agendamentoRepository;

        public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository, BarbeiroRepository barbeiroRepository){
            this.agendamentoRepository= agendamentoRepository;
            this.barbeiroRepository = barbeiroRepository;
        }

        @Override
        public BarbeiroModel buscarBarbeiroporNome(String nome){
            return barbeiroRepository.findByNome(nome);
        }

        @Override
        public AgendamentoModel salvarAgendamento(AgendamentoModel agendamento){
            LocalDateTime dataHora = agendamento.getDataHora();
            BarbeiroModel nome = agendamento.getNome();
            if(agendamentoRepository.existsByDataHoraAndNome(dataHora, nome)){
                
                 throw new IllegalArgumentException("Erro: Horário já agendado para este barbeiro.");
                
            }
            return agendamentoRepository.save(agendamento);
        }

        @Override
        public void deletarAgendamento(Long id){
            agendamentoRepository.deleteById(id);
        }
}
