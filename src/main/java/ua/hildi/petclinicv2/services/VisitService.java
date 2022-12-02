package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hildi.petclinicv2.model.Visit;
import ua.hildi.petclinicv2.repositories.VisitRepository;
import ua.hildi.petclinicv2.util.exceptions.SpecialityNotFoundException;
import ua.hildi.petclinicv2.util.exceptions.VisitNotFoundException;

import java.util.List;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Transactional(readOnly = true)
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong)
                .stream()
                .findAny()
                .orElseThrow(VisitNotFoundException::new);
    }

    @Transactional
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Transactional
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Transactional
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
