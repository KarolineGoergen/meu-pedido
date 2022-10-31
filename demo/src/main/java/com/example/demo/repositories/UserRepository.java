package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Login;

@Repository
public interface UserRepository extends JpaRepository<Login, Integer> {
    
    Login findByUsername(String string);
}
