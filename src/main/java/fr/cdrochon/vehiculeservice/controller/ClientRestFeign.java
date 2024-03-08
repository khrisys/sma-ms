package fr.cdrochon.vehiculeservice.controller;

import fr.cdrochon.vehiculeservice.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestFeign {
    
    @GetMapping("/client/{id}")
    Client findClientById(@PathVariable Long id);
    
    @GetMapping("/clients")
    List<Client> findEveryClients();
}
