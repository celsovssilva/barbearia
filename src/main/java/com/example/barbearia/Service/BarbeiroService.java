package com.example.barbearia.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbearia.Model.BarbeiroModel;


@Service
public interface  BarbeiroService {
    BarbeiroModel cadastroBarbeiro(BarbeiroModel barbeiro);
    List<BarbeiroModel> listarBarbeiros();
    BarbeiroModel buscarBarbeiro(Long id);
    void deletarBarbeiro(Long id);
    
}
