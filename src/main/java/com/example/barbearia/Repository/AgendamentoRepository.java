package com.example.barbearia.Repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barbearia.Model.AgendamentoModel;
import com.example.barbearia.Model.BarbeiroModel;


public interface AgendamentoRepository extends JpaRepository<AgendamentoModel,Long>{
     boolean existsByDataHoraAndNome(LocalDateTime dataHora, BarbeiroModel nome);
}
