package com.example.barbearia.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;


public interface AgendamentoRepository extends JpaRepository<AgendamentoModel,Long>{
     boolean existsByDataInicioAndDataFimAndNomeBarbeiro(LocalDateTime dataHoraInicio,
    LocalDateTime dataHoraFim,
    BarbeiroModel nomeBarbeiro);
    List<AgendamentoModel> findByDataInicioBetween(LocalDate dataInicio, LocalDate dataFim);
}

