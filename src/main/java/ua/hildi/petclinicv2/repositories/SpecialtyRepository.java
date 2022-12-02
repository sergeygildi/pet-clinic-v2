package ua.hildi.petclinicv2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Speciality;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SpecialtyRepository extends JpaRepository<Speciality, Long> {
}
