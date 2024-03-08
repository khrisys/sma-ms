package fr.cdrochon.documentservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomDocument;
    private String titreDocument;
    private TypeDocument typeDocument;
    private String emetteurDuDocument;
    private LocalDate dateCreationDocument;
    private LocalDate dateModificationDocument;
}
