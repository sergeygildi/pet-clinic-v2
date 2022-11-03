package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import ua.hildi.petclinicv2.model.PetType;

import java.util.List;

public interface PetTypeRepository extends Repository<PetType, Long> {

    List<PetType> findAll() throws DataAccessException;

    PetType findOne(Long id) throws DataAccessException;

    void save(PetType pet) throws DataAccessException;
}
