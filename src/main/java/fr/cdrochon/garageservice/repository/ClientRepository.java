package fr.cdrochon.garageservice.repository;

import fr.cdrochon.garageservice.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
