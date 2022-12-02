package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hildi.petclinicv2.model.Owner;
import ua.hildi.petclinicv2.repositories.OwnerRepository;
import ua.hildi.petclinicv2.util.exceptions.OwnerNotFoundException;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Transactional(readOnly = true)
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Transactional(readOnly = true)
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Transactional(readOnly = true)
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong)
                .stream()
                .findFirst()
                .orElseThrow(OwnerNotFoundException::new);
    }

    @Transactional
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Transactional
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Transactional
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
