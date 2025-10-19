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
            LocalDateTime dataHora = agendamento.getDataInicio();
            LocalDateTime dataHoraFim = agendamento.getDataFim();
            BarbeiroModel nomeBarbeiro = agendamento.getNomeBarbeiro();
            if(agendamentoRepository.existsByDataInicioAndDataFimAndNomeBarbeiro(dataHora,dataHoraFim, nomeBarbeiro)){
                
                throw new IllegalArgumentException("Horário indisponível para o barbeiro selecionado.");
                
            }
            return agendamentoRepository.save(agendamento);
        }

        @Override
        public AgendamentoModel atualizarAgendamento(AgendamentoModel agendamento) {
            LocalDateTime dataHora = agendamento.getDataInicio();
            LocalDateTime dataFim = agendamento.getDataFim();
            BarbeiroModel nomeBarbeiro = agendamento.getNomeBarbeiro();
            if (agendamentoRepository.existsByDataInicioAndDataFimAndNomeBarbeiro(dataHora, dataFim,
                    nomeBarbeiro)) {
                        throw new IllegalArgumentException ("horário está ocupado");
                        
                    }
            else{
                            return agendamentoRepository.save(agendamento);
                        }
        }

        @Override
        public void deletarAgendamento(Long id){
            agendamentoRepository.deleteById(id);
        }
}
