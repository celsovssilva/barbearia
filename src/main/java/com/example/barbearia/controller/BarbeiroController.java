package com.example.barbearia.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.barbearia.Service.BarbeiroService;
import com.example.barbearia.Model.BarbeiroModel;
import com.example.barbearia.Repository.BarbeiroRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/barbeiros")
public class BarbeiroController {
    private final BarbeiroService barbeiroService;
    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroController(BarbeiroService barbeiroService, BarbeiroRepository BarbeiroRepository){
        this.barbeiroService = barbeiroService;
        this.barbeiroRepository = BarbeiroRepository;
    }

    @GetMapping
    public List<BarbeiroModel> mostrarBarbeiro(){
        return barbeiroService.mostrarBarbeiros();
    }

    @PostMapping("/cadastrar")
    public BarbeiroModel cadastroBarbeiro(@RequestBody BarbeiroModel barbeiroModel){
        return barbeiroService.cadastroBarbeiro(barbeiroModel);
    }

    @GetMapping("/buscar/{id}")
    public BarbeiroModel buscar(Long id){
        return barbeiroService.buscar(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(long id){
        barbeiroService.deletar(id);
    }
    
    
    
}
