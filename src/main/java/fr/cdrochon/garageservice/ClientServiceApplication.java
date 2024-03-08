package fr.cdrochon.garageservice;

import fr.cdrochon.garageservice.entity.AdresseClient;
import fr.cdrochon.garageservice.entity.Client;
import fr.cdrochon.garageservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClientServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
    
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            
            AdresseClient adresse1 = AdresseClient.builder()
                                                  .rue("rue du truc")
                                                  .numeroDeRue("17")
                                                  .cp("33300")
                                                  .ville("St Jean")
                                                  .build();
            AdresseClient adresse2 = AdresseClient.builder()
                                                  .rue("avenue du jo")
                                                  .cp("59140")
                                                  .numeroDeRue("51")
                                                  .ville("Cloerwak")
                                                  .build();
            
            List<Client> customerList = List.of(
                    
                    
                    Client.builder()
                          .nomClient("Dubourg")
                          .prenomClient("Jean")
                          .mailClient("jean.dubourg@gmail.com")
                          .telClient("0123456789")
                          .adresseClient(adresse1)
                          .build(),
                    Client.builder()
                          .nomClient("Berga")
                          .prenomClient("Christine")
                          .mailClient("chirstine.berga@tut.io")
                          .telClient("9876541320")
                          .adresseClient(adresse2)
                          .build(),
                    Client.builder()
                          .nomClient("Poloua")
                          .prenomClient("Gerard")
                          .mailClient("gegelembrouille@tut.io")
                          .telClient("8888888888")
                          .adresseClient(adresse2)
                          .build()
            
            );
            clientRepository.saveAll(customerList);
        };
    }
    
}
