package com.example.demo.models.dtos;

import com.example.demo.models.Item;

public class ItemDTO {
    
    private int id;
    private int produto;
    private int quantidade;
    private double valor;
    private double subTotal;

    public ItemDTO() {
    }

    public ItemDTO(Item obj) {
        this.id = obj.getId();
        this.produto = obj.getProduto().getId();
        this.quantidade = obj.getQuantidade();
        this.valor = obj.getProduto().getValorUn();
        this.subTotal = obj.getSubTotal();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
