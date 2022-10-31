package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Login;
import com.example.demo.services.CreateLoginService;

@RestController
@RequestMapping(value = "/login")
public class UserResource {

        @Autowired
        CreateLoginService createLoginService;

        @PostMapping
        public Login create(@RequestBody Login login){
            return createLoginService.create(login);
        }

    
}
