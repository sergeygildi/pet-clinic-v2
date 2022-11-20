package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Vet;
import ua.hildi.petclinicv2.repositories.VetRepository;

import java.util.List;

@Service
public class VetService {

    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
