package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.domain.Clients;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Clients clients) {
        this.id = clients.getId();
        this.name = clients.getName();
        this.cpf = clients.getCpf();
        this.income = clients.getIncome();
        this.birthDate = clients.getBirthDate();
        this.children = clients.getChildren();
    }

    public ClientDTO orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}
