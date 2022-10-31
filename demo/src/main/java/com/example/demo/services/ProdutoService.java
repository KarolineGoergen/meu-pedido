package com.example.demo.services;
import com.example.demo.services.exceptions.ObjectnotFoundException;
import com.example.demo.models.Produto;
import com.example.demo.models.dtos.ProdutoDTO;
import com.example.demo.repositories.ProdutoRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto findById(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Produto não encontrado! Id: " + id));
	}

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto create(ProdutoDTO objDTO) {
        objDTO.setId(-1);
        Produto newObj = new Produto(objDTO);
        return produtoRepository.save(newObj);
    }

    public Produto update(Integer id, @Valid ProdutoDTO objDTO) {
        objDTO.setId(id);
        Produto oldObj = findById(id);
        oldObj = new Produto(objDTO);
        return produtoRepository.save(oldObj);
    }

    public void delete(Integer id) {
        produtoRepository.deleteById(id);
    }

  

  

  
}
