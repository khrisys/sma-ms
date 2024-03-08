package fr.cdrochon.vehiculeservice;

import fr.cdrochon.vehiculeservice.entity.MarqueVehicule;
import fr.cdrochon.vehiculeservice.entity.TypeVehicule;
import fr.cdrochon.vehiculeservice.entity.Vehicule;
import fr.cdrochon.vehiculeservice.repository.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VehiculeServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(VehiculeServiceApplication.class, args);
    }
    
    @Bean
    CommandLineRunner commandLineRunner(VehiculeRepository vehiculeRepository) {
        return args -> {
            
            List<Vehicule> vehiculeList = List.of(
                    
                    Vehicule.builder()
                            .immatriculationVehicule("PD-158-DZ")
                            .dateMiseEnCirculationVehicule(LocalDate.now())
                            .climatisationVehicule(true)
                            .typeVehicule(TypeVehicule.VOITURE)
                            .marqueVehicule(MarqueVehicule.BMW)
                            .build(),
                    Vehicule.builder()
                            .immatriculationVehicule("OS-184-PS")
                            .dateMiseEnCirculationVehicule(LocalDate.of(2020, 12, 14))
                            .climatisationVehicule(false)
                            .typeVehicule(TypeVehicule.MOTO)
                            .marqueVehicule(MarqueVehicule.HARLEY_DAVIDSON)
                            .build(),
                    Vehicule.builder()
                            .immatriculationVehicule("SS-147-DG")
                            .dateMiseEnCirculationVehicule(LocalDate.of(2023, 8, 1))
                            .climatisationVehicule(true)
                            .typeVehicule(TypeVehicule.VOITURE)
                            .marqueVehicule(MarqueVehicule.AUDI)
                            .build()
            
            );
            vehiculeRepository.saveAll(vehiculeList);
        };
    }
    
}