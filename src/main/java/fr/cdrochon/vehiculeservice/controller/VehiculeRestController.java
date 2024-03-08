package fr.cdrochon.vehiculeservice.controller;

import fr.cdrochon.vehiculeservice.entity.Vehicule;
import fr.cdrochon.vehiculeservice.repository.VehiculeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculeRestController {
    
    private VehiculeRepository vehiculeRepository;
    
    public VehiculeRestController(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }
    
    @GetMapping("/vehicule/{id}")
    public Vehicule vehiculeById(@PathVariable Long id) {
        return vehiculeRepository.findById(id)
                                 .get();
    }
    
    @GetMapping("/vehicules")
    public List<Vehicule> getVehicules() {
        return vehiculeRepository.findAll();
    }
}
