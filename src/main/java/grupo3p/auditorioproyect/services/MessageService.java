package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Message;
import grupo3p.auditorioproyect.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Message save(Message salvage){
        return messageRepository.save(salvage);
    }
}
