package ua.hildi.petclinicv2.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.hildi.petclinicv2.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
