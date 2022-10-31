package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Encomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable=true)
    private LocalDateTime dataEncomenda;
    @Column(nullable=false)
    private LocalDateTime dataEntrega;
    @Column(nullable=false)
    private String observacao;
    @Column(nullable=true)
    private double valorTotal;

    @OneToMany(mappedBy = "encomenda")
    private List<Item> itens;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cliente cliente;

    @Column(nullable=false)
    private String cidade;
    @Column(nullable=false)
    private String bairro;
    @Column(nullable=false)
    private String logradouro;
    @Column(nullable=false)
    private int numero;
    private int status;

    public Encomenda(int id, LocalDateTime dataEncomenda, LocalDateTime dataEntrega, String observacao,
            double valorTotal, List<Item> itens, Cliente cliente, String cidade, String bairro, String logradouro,
            int numero, int status) {
        this.id = id;
        this.dataEncomenda = dataEncomenda;
        this.dataEntrega = dataEntrega;
        this.observacao = observacao;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.cliente = cliente;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.status = status;
    }


    public Encomenda() {
    }


    public double valorTotal() {
		double soma = 0.0;
		for (Item itemEncomenda : itens) {
			soma = soma + itemEncomenda.getSubTotal();
		}
		return soma;
	}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getDataEncomenda() {
        return dataEncomenda;
    }
    public void setDataEncomenda(LocalDateTime dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }
    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
   
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
 
    public List<Item> getItens() {
        return itens;
    }
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
}
