package ua.hildi.petclinicv2.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.hildi.petclinicv2.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
