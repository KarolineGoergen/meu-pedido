package com.example.demo.models.dtos;

import javax.validation.constraints.NotNull;

import com.example.demo.models.Cliente;

public class ClienteDTO {
  
    private int id;
    @NotNull(message = "O campo Nome é obrigatório!")
    private String nome;
    @NotNull(message = "O campo Email é obrigatório!")
    private String email;
    @NotNull(message = "O campo CPF é obrigatório!")
    private String cpf;
    @NotNull(message = "O campo Telefone é obrigatório!")
    private String telefone;
    private int status;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
        this.status = obj.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
