package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import ua.hildi.petclinicv2.model.Authority;

import java.util.Collection;

public interface AuthorityRepository extends Repository<Authority, Long> {

    Authority findByAuthority(String authority) throws DataAccessException;

    Collection<Authority> findAll() throws DataAccessException;

    Authority findById(Long id) throws DataAccessException;

}
