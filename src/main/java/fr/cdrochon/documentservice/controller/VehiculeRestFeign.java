package fr.cdrochon.documentservice.controller;

import fr.cdrochon.documentservice.model.MarqueVehicule;
import fr.cdrochon.documentservice.model.TypeVehicule;
import fr.cdrochon.documentservice.model.Vehicule;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

/**
 * Communication inter services avec prise en charge de la tolerance aux pannes au cas où le ms Vehicule ne
 * repondrait pas
 * <p>
 * Miroir de la classe Vehicule du ms VehiculeService
 */
@FeignClient(name = "VEHICULE-SERVICE")
public interface VehiculeRestFeign {
    
    @GetMapping("/vehicule/{id}")
    @CircuitBreaker(name = "vehiculeService", fallbackMethod = "getDefaultVehicule")
    Vehicule findVehiculeById(@PathVariable Long id);
    
    @GetMapping("/vehicules")
    @CircuitBreaker(name = "vehiculeService", fallbackMethod = "getDefaultAllVehicules")
    List<Vehicule> findEveryVehicules();
    
    /**
     * Comportement par defaut lorsque le microservice vehicule ne repond pas.
     *
     * @param id        id du vehicule
     * @param exception type exception
     * @return objet vehicule vide
     */
    default Vehicule getDefaultVehicule(Long id, Exception exception) {
        
        Vehicule vehicule = new Vehicule();
        vehicule.setId(id);
        vehicule.setDateMiseEnCirculationVehicule(LocalDate.MIN);
        vehicule.setImmatriculationVehicule("Non disponible");
        vehicule.setTypeVehicule(TypeVehicule.VOITURE);
        vehicule.setMarqueVehicule(MarqueVehicule.NON_DISPONIBLE);
        vehicule.setClimatisationVehicule(false);
        System.err.println("Exception default getDefaultClient : " + exception.getMessage());
        return vehicule;
    }
    
    /**
     * Retourne une liste vide de vehicules par defaut
     *
     * @param exception type exception
     * @return liste vide de vehicules
     */
    default List<Vehicule> getDefaultAllVehicules(Exception exception) {
        System.err.println("Exception default getDefaultAllClients : " + exception.getMessage());
        return List.of();
    }
}
