package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hildi.petclinicv2.model.Speciality;
import ua.hildi.petclinicv2.repositories.SpecialtyRepository;
import ua.hildi.petclinicv2.util.exceptions.SpecialityNotFoundException;

import javax.sql.rowset.spi.SyncProviderException;
import java.util.List;

@Service
public class SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialityService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Transactional(readOnly = true)
    public List<Speciality> findAll() {
        return specialtyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Speciality findById(Long aLong) {
        return specialtyRepository
                .findById(aLong)
                .stream()
                .findAny()
                .orElseThrow(SpecialityNotFoundException::new);
    }

    @Transactional
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Transactional
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Transactional
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
