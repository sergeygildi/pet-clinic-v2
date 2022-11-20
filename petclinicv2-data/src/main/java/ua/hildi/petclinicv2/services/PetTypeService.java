package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.PetType;
import ua.hildi.petclinicv2.repositories.PetTypeRepository;

import java.util.List;

@Service
public class PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    public List<PetType> findAll() {
        return petTypeRepository.findAll();
    }

    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
