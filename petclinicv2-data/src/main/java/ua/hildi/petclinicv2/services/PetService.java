package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Pet;
import ua.hildi.petclinicv2.repositories.PetRepository;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    public void delete(Pet object) {
        petRepository.delete(object);
    }

    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
