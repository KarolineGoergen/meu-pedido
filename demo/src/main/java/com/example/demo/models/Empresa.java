package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;

import com.example.demo.models.dtos.EmpresaDTO;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private String nome;
    @Column(nullable=true)
    private String descricao; 
    @CNPJ
    @Column(nullable=false)
    private String cod;
    @Email
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String telefone;
    @Column(nullable=false)
    private String cidade;
    @Column(nullable=false)
    private String bairro;
    @Column(nullable=false)
    private String logradouro;
    @Column(nullable=false)
    private int numero;

    public Empresa() {
    }

    public Empresa(EmpresaDTO obj) {
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
