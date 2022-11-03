package ua.hildi.petclinicv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.PetType;

import java.util.List;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {

    List<PetType> findAll();

    PetType save(PetType pet);
}
