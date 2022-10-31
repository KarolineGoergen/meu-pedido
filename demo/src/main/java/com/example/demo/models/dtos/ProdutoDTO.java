package com.example.demo.models.dtos;

import javax.validation.constraints.NotNull;

import com.example.demo.models.Produto;

public class ProdutoDTO {
    
    private int id;
    @NotNull(message = "O campo Nome é obrigatório!")
    private String nome;
    private String descricao;
    private String unMedida;
    @NotNull(message = "O campo Valor é obrigatório!")
    private double valorUn;
    private int status;
    
    public ProdutoDTO(Produto obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
        this.unMedida = obj.getUnMedida();
        this.valorUn = obj.getValorUn();
        this.status = obj.getStatus();
    }

    public ProdutoDTO() {
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
    public String getUnMedida() {
        return unMedida;
    }
    public void setUnMedida(String unMedida) {
        this.unMedida = unMedida;
    }
    public double getValorUn() {
        return valorUn;
    }
    public void setValorUn(double valorUn) {
        this.valorUn = valorUn;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
