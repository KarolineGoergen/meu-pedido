package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Encomenda;

public interface EncomendaRepository extends JpaRepository<Encomenda, Integer> {
    
}
