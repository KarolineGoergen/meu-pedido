package com.example.demo.models;


import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Produto produto;

    private String nomeProduto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Encomenda encomenda;

    @Column(nullable=true)
    private int quantidade;
    @Column(nullable=true)
    private double valor;
  
    private double subTotal;


    public Item() {
    }

    public Item(int id, Produto produto, String nomeProduto, int quantidade, double valor, double subTotal) {
        this.id = id;
        this.produto = produto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.subTotal = subTotal;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSubTotal(){
        return subTotal;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }
    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String string) {
        this.nomeProduto = string;
    }
}
