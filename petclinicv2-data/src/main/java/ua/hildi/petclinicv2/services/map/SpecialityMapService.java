package ua.hildi.petclinicv2.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ua.hildi.petclinicv2.model.Speciality;
import ua.hildi.petclinicv2.services.SpecialtyService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
