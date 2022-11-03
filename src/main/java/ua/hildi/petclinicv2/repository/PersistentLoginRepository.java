package ua.hildi.petclinicv2.repository;

import org.springframework.data.repository.Repository;
import ua.hildi.petclinicv2.model.PersistentLogin;

public interface PersistentLoginRepository extends Repository<PersistentLogin, String> {
}
