package ua.hildi.petclinicv2.repository;

import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Message;

import java.util.Collection;

@Repository
public interface MessageRepository {

    Collection<Message> findAll();

    Message save(Message message);

    Message findById(Long id);

}
