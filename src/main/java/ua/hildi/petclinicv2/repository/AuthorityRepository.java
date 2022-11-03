package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Authority;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByAuthority(String authority) throws DataAccessException;

    List<Authority> findAll() throws DataAccessException;

    Optional<Authority> findById(Long id) throws DataAccessException;

}
