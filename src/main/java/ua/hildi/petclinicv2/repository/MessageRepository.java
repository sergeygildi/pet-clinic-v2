package ua.hildi.petclinicv2.repository;

import ua.hildi.petclinicv2.model.Message;

import java.util.Collection;

public interface MessageRepository {

    Collection<Message> findAll();

    Message save(Message message);

    Message findById(Long id);

}
