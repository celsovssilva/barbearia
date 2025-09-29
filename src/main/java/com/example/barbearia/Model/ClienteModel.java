package com.example.barbearia.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private int idade;
    

    public ClienteModel(){

    }
    public ClienteModel(String nome, String telefone, int idade) {
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
      
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome= nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone= telefone;
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade= idade;
    }
}
