package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import ua.hildi.petclinicv2.model.User;

import java.util.Collection;

public interface UserRepository extends Repository<User, Long> {

    Collection<User> findByNameLike(String name) throws DataAccessException;

    User findByUsername(String username) throws DataAccessException;

    Collection<User> findAll() throws DataAccessException;

    User findById(Long id) throws DataAccessException;

    User save(User user) throws DataAccessException;

    User delete(User user) throws DataAccessException;

    boolean exists(Long userId) throws DataAccessException;

}
