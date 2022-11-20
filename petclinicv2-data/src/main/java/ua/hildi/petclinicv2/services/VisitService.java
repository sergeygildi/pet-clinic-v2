package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Visit;
import ua.hildi.petclinicv2.repositories.VisitRepository;

import java.util.List;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
