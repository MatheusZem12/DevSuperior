package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.domain.Clients;
import com.example.demo.dto.ClientDTO;
import com.example.demo.exceptions.NotFoundClientException;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        return clientRepository.findById(id).map(ClientDTO::new).orElseThrow(() -> new NotFoundClientException("Client not found"));
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable).map(ClientDTO::new);
    }

    @Transactional
    public Long save(ClientDTO clientDTO) {
        return clientRepository.save(toEntity(clientDTO)).getId();
    }

    @Transactional
    public Long delete(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new NotFoundClientException("Client not found");
        }
        clientRepository.deleteById(id);
        return id;
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        if(!clientRepository.existsById(id)) {
            throw new NotFoundClientException("Client not found");
        }
        Clients clients = toEntity(clientDTO);
        clients.setId(id);
        return new ClientDTO(clientRepository.save(clients));
    }


    Clients toEntity(ClientDTO clientDTO) {
        Clients clients = new Clients();
        clients.setName(clientDTO.getName());
        clients.setCpf(clientDTO.getCpf());
        clients.setIncome(clientDTO.getIncome());
        if(clientDTO.getBirthDate().isAfter(LocalDate.now())) {
            throw new DataIntegrityViolationException("Birth date cannot be greater than the current date");
        }
        clients.setBirthDate(clientDTO.getBirthDate());
        clients.setChildren(clientDTO.getChildren());
        return clients;
    }


}
