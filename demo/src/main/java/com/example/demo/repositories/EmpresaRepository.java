package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
}
