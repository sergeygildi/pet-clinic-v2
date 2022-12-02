package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hildi.petclinicv2.model.Vet;
import ua.hildi.petclinicv2.repositories.VetRepository;
import ua.hildi.petclinicv2.util.exceptions.SpecialityNotFoundException;
import ua.hildi.petclinicv2.util.exceptions.VetNotFoundException;

import java.util.List;

@Service
public class VetService {

    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Transactional(readOnly = true)
    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong)
                .stream()
                .findAny()
                .orElseThrow(VetNotFoundException::new);
    }

    @Transactional
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Transactional
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Transactional
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
