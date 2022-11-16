package ua.hildi.petclinicv2.services;

import java.util.List;

public interface JpaService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
