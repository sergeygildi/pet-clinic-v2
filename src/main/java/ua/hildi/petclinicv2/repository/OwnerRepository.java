package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import sample.ui.model.BaseEntity;
import ua.hildi.petclinicv2.model.Owner;

import java.util.Collection;

public interface OwnerRepository extends Repository<Owner, Long> {

    Collection<Owner> findByLastNameStartingWithIgnoreCase(String lastName) throws DataAccessException;

    Collection<Owner> findAll() throws DataAccessException;

    Owner findById(Long id) throws DataAccessException;

    void save(Owner owner) throws DataAccessException;

}
