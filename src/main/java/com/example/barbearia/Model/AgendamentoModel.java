package com.example.barbearia.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agendamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgendamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    @ManyToOne(fetch = FetchType.EAGER)
    private BarbeiroModel nomeBarbeiro;
  

}
