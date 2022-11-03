package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Vet;

import java.util.List;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

    List<Vet> findAll() throws DataAccessException;

    Vet save(Vet vet) throws DataAccessException;
}
