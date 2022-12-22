package com.example.demo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.models.Encomenda;
import com.example.demo.models.dtos.EncomendaDTO;
import com.example.demo.services.EncomendaService;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/encomendas")
public class EncomendaResource {
    
    @Autowired
    private EncomendaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<EncomendaDTO> findById(@PathVariable Integer id){
		Encomenda obj = service.findById(id);
		return ResponseEntity.ok().body(new EncomendaDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<EncomendaDTO>> findAll() {
		List<Encomenda> list = service.findAll();
		List<EncomendaDTO> listDTO = list.stream().map(obj -> new EncomendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<EncomendaDTO> create(@Valid @RequestBody EncomendaDTO obj){
		Encomenda newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
    public ResponseEntity<EncomendaDTO> update(@PathVariable Integer id, @Valid @RequestBody EncomendaDTO objDTO){
        Encomenda obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new EncomendaDTO(obj));
    }
	
	@PutMapping(value = "/cancelar/{id}")
    public ResponseEntity<EncomendaDTO> cancelar(@PathVariable Integer id, @Valid @RequestBody EncomendaDTO objDTO){
        Encomenda obj = service.cancelar(id, objDTO);
        return ResponseEntity.ok().body(new EncomendaDTO(obj));
    }
	
	

   

	
}
