package com.example.barbearia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barbearia.Model.AgendamentoModel;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel,Long>{
    
}
