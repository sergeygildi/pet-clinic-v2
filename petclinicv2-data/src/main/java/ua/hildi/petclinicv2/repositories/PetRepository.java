package ua.hildi.petclinicv2.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.hildi.petclinicv2.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
