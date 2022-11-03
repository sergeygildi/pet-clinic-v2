package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import ua.hildi.petclinicv2.model.Vet;

import java.util.Collection;

public interface VetRepository extends Repository<Vet, Long> {

    Collection<Vet> findAll() throws DataAccessException;

    void save(Vet vet) throws DataAccessException;
}
