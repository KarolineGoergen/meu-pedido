package com.example.demo.models;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;

import com.example.demo.models.dtos.ProdutoDTO;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=true)
    private String nome;
    @Column(nullable=false)
    private String descricao;
    @Column(nullable=false)
    private String unMedida;
    @Column(nullable=true)
    private double valorUn;
    private int status;

    @OneToMany(mappedBy = "produto")
    private List<Item> itens;

    public Produto() {
    }

    public Produto(ProdutoDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
        this.unMedida = obj.getUnMedida();
        this.valorUn = obj.getValorUn();
        this.status = obj.getStatus();
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

  
}
