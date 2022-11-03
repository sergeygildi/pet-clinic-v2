package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import ua.hildi.petclinicv2.model.Visit;

import java.util.List;

public interface VisitRepository extends Repository<Visit, Long> {

    void save(Visit visit) throws DataAccessException;

    List<Visit> findByPetId(Long petId);

}
