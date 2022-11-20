package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.repositories.OwnerRepository;
import ua.hildi.petclinicv2.repositories.PetRepository;
import ua.hildi.petclinicv2.repositories.PetTypeRepository;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerService(OwnerRepository ownerRepository, PetRepository petRepository,
                        PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
