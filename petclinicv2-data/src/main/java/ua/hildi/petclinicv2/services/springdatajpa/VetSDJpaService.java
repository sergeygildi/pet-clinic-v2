package ua.hildi.petclinicv2.services.springdatajpa;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Vet;
import ua.hildi.petclinicv2.repositories.VetRepository;
import ua.hildi.petclinicv2.services.VetService;

import java.util.List;

@Service
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
