package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Message;
import grupo3p.auditorioproyect.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getById(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message salvage){
        return messageCrudRepository.save(salvage);
    }

    public void delete(Message endMessage){
        messageCrudRepository.delete(endMessage);
    }
}
