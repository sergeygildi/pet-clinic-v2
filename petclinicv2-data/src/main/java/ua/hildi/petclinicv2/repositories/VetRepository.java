package ua.hildi.petclinicv2.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.hildi.petclinicv2.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
