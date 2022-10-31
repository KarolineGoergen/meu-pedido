package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.Login;
import com.example.demo.repositories.UserRepository;

@Service
public class CreateLoginService {

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    UserRepository userRepository;

    public Login create(Login login){
        
        Login exist = userRepository.findByUsername(login.getUsername());

        if(exist != null){
            throw new Error("Usuário já existe!");
        }

        login.setPassword(passwordEncoder().encode(login.getPassword()));
        return userRepository.save(login);
    }
}
