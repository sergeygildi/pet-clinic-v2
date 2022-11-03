package ua.hildi.petclinicv2.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Visit;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Visit save(Visit visit) throws DataAccessException;

    List<Visit> findByPetId(Long petId);

}
