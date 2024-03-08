package fr.cdrochon.documentservice;

import fr.cdrochon.documentservice.entity.Document;
import fr.cdrochon.documentservice.entity.TypeDocument;
import fr.cdrochon.documentservice.repository.DocumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DocumentServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DocumentServiceApplication.class, args);
    }
    
    @Bean
    CommandLineRunner commandLineRunner(DocumentRepository documentRepository) {
        return args -> {
            
            List<Document> documents = List.of(
                    
                    Document.builder()
                            .nomDocument("devis-00012547")
                            .titreDocument("rdv pour essieu")
                            .emetteurDuDocument("garage durand")
                            .typeDocument(TypeDocument.DEVIS)
                            .dateCreationDocument(LocalDate.now())
                            .dateModificationDocument(LocalDate.now())
                            .build(),
                    Document.builder()
                            .nomDocument("facture mr X")
                            .titreDocument("facture du garage robert")
                            .emetteurDuDocument("garage robert")
                            .typeDocument(TypeDocument.FACTURE)
                            .dateCreationDocument(LocalDate.now())
                            .dateModificationDocument(LocalDate.now())
                            .build(),
                    Document.builder()
                            .nomDocument("devis sans titre")
                            .emetteurDuDocument("garage durand")
                            .typeDocument(TypeDocument.DEVIS)
                            .dateCreationDocument(LocalDate.now())
                            .dateModificationDocument(LocalDate.now())
                            .build()
            
            );
            documentRepository.saveAll(documents);
        };
    }
}
