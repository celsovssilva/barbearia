package com.example.barbearia.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.barbearia.Model.ClienteModel;
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
   Optional<ClienteModel> findById(Long id);

}
