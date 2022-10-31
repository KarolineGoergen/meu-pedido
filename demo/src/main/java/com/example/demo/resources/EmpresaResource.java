package com.example.demo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.models.Empresa;
import com.example.demo.models.dtos.EmpresaDTO;
import com.example.demo.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresas", produces = "application/json")
public class EmpresaResource {

    @Autowired
    private EmpresaService service;
   
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO> findById(@PathVariable Integer id){
        Empresa obj = service.findById(id);
        return ResponseEntity.ok().body(new EmpresaDTO(obj));
    }
    
    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@Valid @RequestBody EmpresaDTO objDTO){
        Empresa newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable Integer id, @Valid @RequestBody EmpresaDTO objDTO){
        Empresa obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new EmpresaDTO(obj));
    }


}
