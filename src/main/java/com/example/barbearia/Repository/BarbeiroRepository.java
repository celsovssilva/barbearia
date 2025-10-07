package com.example.barbearia.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barbearia.Model.BarbeiroModel;


public interface BarbeiroRepository extends JpaRepository<BarbeiroModel, Long> {

    BarbeiroModel findByNome(String nome);

    
}
