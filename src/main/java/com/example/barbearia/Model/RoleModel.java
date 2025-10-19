package com.example.barbearia.Model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleModel implements GrantedAuthority {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY);
    private Long id;
    private String nome;

    @Override
    public String getAuthority() {
        return this.nome;
    }

    
}
