package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Owner;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Collection<Owner> findByLastNameStartingWithIgnoreCase(String lastName) throws DataAccessException;

    List<Owner> findAll() throws DataAccessException;

    Optional<Owner> findById(Long id) throws DataAccessException;

    Owner save(Owner owner) throws DataAccessException;
}
