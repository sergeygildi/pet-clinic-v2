package ua.hildi.petclinicv2.services.springdatajpa;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Speciality;
import ua.hildi.petclinicv2.repositories.SpecialtyRepository;
import ua.hildi.petclinicv2.services.SpecialtyService;

import java.util.List;

@Service
public class SpecialitySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<Speciality> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
