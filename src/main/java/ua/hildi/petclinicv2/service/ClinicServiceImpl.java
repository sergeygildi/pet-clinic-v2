package ua.hildi.petclinicv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hildi.petclinicv2.model.*;
import ua.hildi.petclinicv2.repository.*;

import java.util.Collection;
import java.util.Optional;

@Service("clinicService")
public class ClinicServiceImpl implements ClinicService {

    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;
    private final VetRepository vetRepository;
    private final OwnerRepository ownerRepository;
    private final VisitRepository visitRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public ClinicServiceImpl(PetRepository petRepository, PetTypeRepository petTypeRepository, VetRepository vetRepository, OwnerRepository ownerRepository, VisitRepository visitRepository, MessageRepository messageRepository, UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.vetRepository = vetRepository;
        this.ownerRepository = ownerRepository;
        this.visitRepository = visitRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PetType> findPetTypes() throws DataAccessException {
        return petTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Owner> findOwnerById(long id) throws DataAccessException {
        return ownerRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
        return ownerRepository.findByLastNameStartingWithIgnoreCase(lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Owner> findOwners() throws DataAccessException {
        return ownerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveOwner(Owner owner) throws DataAccessException {
        ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public void saveVisit(Visit visit) throws DataAccessException {
        visitRepository.save(visit);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pet> findPetById(long id) throws DataAccessException {
        return petRepository.findById(id);
    }

    @Override
    @Transactional
    public void savePet(Pet pet) throws DataAccessException {
        petRepository.save(pet);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "vets")
    public Collection<Vet> findVets() throws DataAccessException {
        return vetRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Message> findMessages() throws DataAccessException {
        return messageRepository.findAll();
    }

    @Override
    @Transactional
    public Message saveMessage(Message message) throws DataAccessException {
        return messageRepository.save(message);
    }

    @Override
    @Transactional(readOnly = true)
    public Message findMessage(Long id) throws DataAccessException {
        return messageRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(String useName) {
        return userRepository.findByUsername(useName);
    }

    @Override
    @Transactional(readOnly = true)
    public User createUser() {
        return new User();
    }

    @Override
    @Transactional(readOnly = true)
    public UserProfile createUserProfile(User user) {
        return new UserProfile(user);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        user.addAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        return userRepository.save(user);
    }
}
