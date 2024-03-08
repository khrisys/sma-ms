package fr.cdrochon.garageservice.controller;

import fr.cdrochon.garageservice.entity.Client;
import fr.cdrochon.garageservice.repository.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestController {
    
    private ClientRepository clientRepository;
    
    public ClientRestController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id)
                               .get();
    }
    
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}
