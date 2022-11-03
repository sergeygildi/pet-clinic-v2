package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username) throws DataAccessException;

    List<User> findAll() throws DataAccessException;

    Optional<User> findById(Long id) throws DataAccessException;

    User save(User user) throws DataAccessException;

    void delete(User user) throws DataAccessException;

}
