package ua.hildi.petclinicv2.services;

import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Speciality;
import ua.hildi.petclinicv2.repositories.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialityService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public List<Speciality> findAll() {
        return specialtyRepository.findAll();
    }

    public Speciality findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
