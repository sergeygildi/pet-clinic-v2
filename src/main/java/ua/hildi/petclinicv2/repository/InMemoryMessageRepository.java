package ua.hildi.petclinicv2.repository;

import org.springframework.stereotype.Repository;
import ua.hildi.petclinicv2.model.Message;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryMessageRepository implements MessageRepository {

    private static final AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, Message> messages = new ConcurrentHashMap<>();

    @Override
    public Collection<Message> findAll() {
        return this.messages.values();
    }

    @Override
    public Message save(Message message) {
        Long id = message.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.messages.put(id, message);
        return message;
    }

    @Override
    public Message findById(Long id) {
        return this.messages.get(id);
    }

}
