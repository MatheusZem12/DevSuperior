package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ClientDTO;
import com.example.demo.services.ClientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/clientes")
@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    
    @GetMapping("{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping()
    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientService.findAll(pageable);
    }
    
    @PostMapping()
    public Long save(@RequestBody ClientDTO clientDTO) {
        return clientService.save(clientDTO);
    }

    @DeleteMapping("{id}")
    public Long delete(@PathVariable Long id) {
        return clientService.delete(id);
    }

    @PutMapping("{id}")
    public ClientDTO putMethodName(@PathVariable Long id, @RequestBody ClientDTO entity) {        
        return clientService.update(id, entity);
    }

    
    
    

}
