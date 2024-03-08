package fr.cdrochon.documentservice.controller;

import fr.cdrochon.documentservice.entity.Document;
import fr.cdrochon.documentservice.repository.DocumentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DocumentRestController {
    
    private final DocumentRepository documentRepository;
    
    public DocumentRestController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
    
    @GetMapping("/document/{id}")
    public Document getDocumentById(@PathVariable Long id){
        return documentRepository.findById(id).get();
    }
    
    @GetMapping("/documents")
    public List<Document> getDocuments(){
        return documentRepository.findAll();
    }
}
