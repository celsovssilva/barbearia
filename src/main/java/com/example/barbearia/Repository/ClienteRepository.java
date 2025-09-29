package com.example.barbearia.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barbearia.Model.ClienteModel;
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    public Object findBy(Long id);
    
}
