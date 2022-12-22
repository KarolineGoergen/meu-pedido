package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.models.Encomenda;
import com.example.demo.models.Item;
import com.example.demo.models.Produto;
import com.example.demo.models.dtos.EncomendaDTO;
import com.example.demo.models.dtos.ItemDTO;
import com.example.demo.repositories.EncomendaRepository;
import com.example.demo.repositories.ItensRepository;
import com.example.demo.services.exceptions.ObjectnotFoundException;

@Service
public class EncomendaService {
    public double soma;

    @Autowired
    private EncomendaRepository encomendaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItensRepository itensRepository;


    public Encomenda findById(Integer id) {
		Optional<Encomenda> obj = encomendaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	  }

    public List<Encomenda> findAll() {
      return encomendaRepository.findAll();
    }

    public Encomenda create(EncomendaDTO obj){

      ModelMapper mapper = new ModelMapper();
      
      Cliente cliente = clienteService.findById(obj.getCliente());

      Encomenda encomenda = mapper.map(obj, Encomenda.class);
      encomenda.setCliente(cliente);
        
      for(ItemDTO itemDTO : obj.getItens()){
        Item item = mapper.map(itemDTO, Item.class);
        Produto produto = produtoService.findById(itemDTO.getProduto());
        item.setEncomenda(encomenda);
        item.setProduto(produto);
        item.setNomeProduto(produto.getNome());
        item.setValor(produto.getValorUn());
        item.setSubTotal(produto.getValorUn()*itemDTO.getQuantidade());
        soma += item.getSubTotal();
        
        itensRepository.save(item);
      }
      encomenda.setValorTotal(soma);
      soma=0;
      return encomendaRepository.save(encomenda);

    }

    public Encomenda update(Integer id, @Valid EncomendaDTO obj){
      obj.setId(id);
      Encomenda oldObj = findById(id);
      oldObj.setStatus(1);
      return encomendaRepository.save(oldObj);
    }

    public Encomenda cancelar(Integer id, @Valid EncomendaDTO obj) {
      obj.setId(id);
      Encomenda oldObj = findById(id);
      oldObj.setStatus(2);
      return encomendaRepository.save(oldObj);
    }

}
