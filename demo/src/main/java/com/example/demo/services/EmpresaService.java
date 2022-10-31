package com.example.demo.services;
import com.example.demo.services.exceptions.ObjectnotFoundException;
import com.example.demo.models.Empresa;
import com.example.demo.models.dtos.EmpresaDTO;
import com.example.demo.repositories.EmpresaRepository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;
    
    public Empresa findById(Integer id) {
		Optional<Empresa> obj = empresaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Empresa não encontrada! Id: " + id));
	}


    public Empresa create(EmpresaDTO objDTO) {
        objDTO.setId(-1);
        Empresa newObj = new Empresa(objDTO);
        return empresaRepository.save(newObj);
    }

    public Empresa update(Integer id, @Valid EmpresaDTO objDTO) {
        objDTO.setId(id);
        Empresa oldObj = findById(id);
        oldObj = new Empresa(objDTO);
        return empresaRepository.save(oldObj);
    }

  

  

  
}
