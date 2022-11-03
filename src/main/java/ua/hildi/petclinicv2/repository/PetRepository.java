package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import ua.hildi.petclinicv2.model.Pet;

public interface PetRepository extends Repository<Pet, Long> {

    Pet findById(Long id) throws DataAccessException;

    void save(Pet pet) throws DataAccessException;

}
