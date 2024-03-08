package fr.cdrochon.vehiculeservice.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter @Setter @ToString
public class AdresseClient {
    
    private String numeroDeRue;
    private String rue;
    private String cp;
    private String ville;
}
