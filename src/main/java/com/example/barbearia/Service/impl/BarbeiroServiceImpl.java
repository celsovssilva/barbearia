package com.example.barbearia.Service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.barbearia.Model.BarbeiroModel;
import com.example.barbearia.Repository.BarbeiroRepository;
import com.example.barbearia.Service.BarbeiroService;



@Service
public class BarbeiroServiceImpl implements BarbeiroService {
    private final BarbeiroRepository barbeiroRepository;
    public BarbeiroServiceImpl(BarbeiroRepository barbeiroRepository){
        this.barbeiroRepository= barbeiroRepository;
    }

    @Override
    public BarbeiroModel cadastroBarbeiro(BarbeiroModel barbeiro){
        return barbeiroRepository.save(barbeiro);
    }

    @Override
    public List<BarbeiroModel> listarBarbeiros(){
        return barbeiroRepository.findAll();
        
    }

    @Override
    public BarbeiroModel buscarBarbeiro(Long id){
        return barbeiroRepository.findById(id).orElse(null);
    }

    @Override
    public void deletarBarbeiro(Long id){
        barbeiroRepository.deleteById(id);
    }

    
}
