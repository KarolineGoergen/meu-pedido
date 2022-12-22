package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Item;
import com.example.demo.repositories.ItensRepository;
import com.example.demo.services.exceptions.ObjectnotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ItensService {

    @Autowired
    ItensRepository repository;
    
    public Item findById(Integer id) {
		Optional<Item> obj = repository.findById(id);
	    return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

    public void save(Item item) {
    }

    public List<Item> findAll() {
        return repository.findAll();
    }
}
