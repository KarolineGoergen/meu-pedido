package com.example.demo.services;
import com.example.demo.services.exceptions.ObjectnotFoundException;
import com.example.demo.services.exceptions.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cliente;
import com.example.demo.models.dtos.ClienteDTO;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Cliente não encontrado! Id: " + id));
	}

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(-1);
        validaCpf(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return clienteRepository.save(newObj);
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = findById(id);
        validaCpf(objDTO);
        oldObj = new Cliente(objDTO);
        return clienteRepository.save(oldObj);
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

    public void validaCpf(ClienteDTO objDTO){
        Optional<Cliente> obj = clienteRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
          throw new DataIntegrityViolationException("CPF já cadastrado!");  
        }
    }

  

  
}
