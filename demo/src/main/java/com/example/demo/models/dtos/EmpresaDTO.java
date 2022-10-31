package com.example.demo.models.dtos;

import javax.validation.constraints.NotNull;

import com.example.demo.models.Empresa;

public class EmpresaDTO {

    private int id;
    @NotNull(message = "O campo Nome é obrigatório!")
    private String nome;
    private String descricao;
    @NotNull(message = "O campo CNPJ é obrigatório!") 
    private String cod;
    @NotNull(message = "O campo Email é obrigatório!")
    private String email;
    @NotNull(message = "O campo Telefone é obrigatório!")
    private String telefone;
    @NotNull(message = "O campo Cidade é obrigatório!")
    private String cidade;
    @NotNull(message = "O campo Bairro é obrigatório!")
    private String bairro;
    @NotNull(message = "O campo Logradouro é obrigatório!")
    private String logradouro;
    @NotNull(message = "O campo Número é obrigatório!")
    private int numero;

    public EmpresaDTO() {
    }

    public EmpresaDTO(Empresa obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
        this.cod = obj.getCod();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
        this.cidade = obj.getCidade();
        this.bairro = obj.getBairro();
        this.logradouro = obj.getLogradouro();
        this.numero = obj.getNumero();
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
