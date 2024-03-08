package fr.cdrochon.documentservice.controller;

import fr.cdrochon.documentservice.model.Vehicule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Miroir de la classe Vehicule du ms VehiculeService
 */
@FeignClient(name = "VEHICULE-SERVICE")
public interface VehiculeRestFeign {
    
    @GetMapping("/vehicule/{id}")
    Vehicule findVehiculeById(@PathVariable Long id);
    
    @GetMapping("/vehicules")
    List<Vehicule> findEveryVehicules();
}
