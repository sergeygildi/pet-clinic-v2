package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.repositories.PetRepository;
import ua.hildi.petclinicv2.util.exceptions.PetNotFoundException;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional(readOnly = true)
    public Set<Pet> findAll() {
        return petRepository.findAll().stream().collect(toSet());
    }

    @Transactional(readOnly = true)
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong)
                .stream()
                .findAny()
                .orElseThrow(PetNotFoundException::new);
    }

    @Transactional
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Transactional
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Transactional
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
