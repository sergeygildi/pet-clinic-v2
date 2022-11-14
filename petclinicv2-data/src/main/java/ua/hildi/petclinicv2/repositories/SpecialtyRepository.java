package ua.hildi.petclinicv2.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.hildi.petclinicv2.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
