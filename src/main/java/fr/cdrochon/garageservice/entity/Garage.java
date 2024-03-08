package fr.cdrochon.garageservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class Garage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomGarage;
    @Embedded
    private Adresse adresseGarage;
//    @Embedded
//    private ResponsableGarage responsableGarage;
    private String emailContactGarage;
}
