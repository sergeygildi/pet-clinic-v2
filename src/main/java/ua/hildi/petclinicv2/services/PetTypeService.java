package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hildi.petclinicv2.model.PetType;
import ua.hildi.petclinicv2.repositories.PetTypeRepository;
import ua.hildi.petclinicv2.util.exceptions.PetTypeNotFoundException;

import java.util.HashSet;
import java.util.Set;

@Service
public class PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Transactional(readOnly = true)
    public Set<PetType> findAll() {
        return new HashSet<>(petTypeRepository.findAll());
    }

    @Transactional(readOnly = true)
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong)
                .stream()
                .findFirst()
                .orElseThrow(PetTypeNotFoundException::new);
    }

    @Transactional
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Transactional
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Transactional
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
