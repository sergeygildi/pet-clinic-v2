package ua.hildi.petclinicv2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Vet;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VetRepository extends JpaRepository<Vet, Long> {
}
