package ua.hildi.petclinicv2.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.hildi.petclinicv2.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
