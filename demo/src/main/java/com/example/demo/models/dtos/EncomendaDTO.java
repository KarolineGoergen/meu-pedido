package com.example.demo.models.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.demo.models.Encomenda;
import com.example.demo.models.Item;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EncomendaDTO {

    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") 
    private LocalDateTime dataEncomenda = LocalDateTime.now();
    private String dataEntrega;
    private String observacao; 
    private double valorTotal;
    @NotNull(message = "Selecione pelo menos um produto!")
    private List<ItemDTO> itens;
    @NotNull(message = "O campo Cliente é obrigatório!")
    private int cliente;
    private String nomeCliente;
    private String cidade;   
    private String bairro;
    private String logradouro;
    private int numero;
    private int status;

    public EncomendaDTO() {

    }

    public EncomendaDTO( Encomenda obj) {
        this.id = obj.getId();
        this.dataEntrega = obj.getDataEntrega();
        this.observacao = obj.getObservacao();
        this.valorTotal = obj.getValorTotal();
        this.itens = new ArrayList<>();
        for(Item item: obj.getItens()){
            this.itens.add(new ItemDTO(item));
        }
        this.cliente = obj.getCliente().getId();
        this.nomeCliente = obj.getCliente().getNome();
        this.cidade = obj.getCidade();
        this.bairro = obj.getBairro();
        this.logradouro = obj.getLogradouro();
        this.numero = obj.getNumero();
        this.status = obj.getStatus();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 
    public String getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(String dataEntrega) {
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
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(LocalDateTime dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}