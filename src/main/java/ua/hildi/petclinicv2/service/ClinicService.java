package ua.hildi.petclinicv2.service;

import org.springframework.dao.DataAccessException;
import ua.hildi.petclinicv2.model.*;

import java.util.Collection;

public interface ClinicService {

    public User createUser();

    public User saveUser(User user) throws DataAccessException;

    public User findUser(String username) throws DataAccessException;

    public UserProfile createUserProfile(User user);

    public Owner findOwnerById(long id) throws DataAccessException;

    public void saveOwner(Owner owner) throws DataAccessException;

    public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;

    public Collection<Owner> findOwners() throws DataAccessException;

    // Pet
    public Pet findPetById(long id) throws DataAccessException;

    public void savePet(Pet pet) throws DataAccessException;

    public Collection<PetType> findPetTypes() throws DataAccessException;

    // Visit
    public void saveVisit(Visit visit) throws DataAccessException;

    // Vet
    public Collection<Vet> findVets() throws DataAccessException;

    // Message
    public Collection<Message> findMessages() throws DataAccessException;

    public Message saveMessage(Message message) throws DataAccessException;

    public Message findMessage(Long id) throws DataAccessException;

}
