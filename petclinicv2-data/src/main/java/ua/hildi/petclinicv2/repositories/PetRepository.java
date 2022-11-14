package ua.hildi.petclinicv2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
