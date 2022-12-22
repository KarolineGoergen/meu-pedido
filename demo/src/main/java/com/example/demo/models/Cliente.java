package com.example.demo.models;

import javax.persistence.*;

import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.example.demo.models.dtos.ClienteDTO;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String nome;
    @Email
    @Column(nullable=false)
    private String email;
    @CPF
    @Column(unique=true, nullable=false)
    private String cpf;
    @Column(nullable=false)
    private String telefone;
    @Column(nullable=false)
    private int status;
    

    public Cliente() {
    }

    public Cliente(ClienteDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
        this.status = obj.getStatus();
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
}
