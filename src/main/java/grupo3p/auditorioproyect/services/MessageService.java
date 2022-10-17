package grupo3p.auditorioproyect.services;

import antlr.debug.MessageAdapter;
import grupo3p.auditorioproyect.entities.Message;
import grupo3p.auditorioproyect.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getById(int id){
        return messageRepository.getById(id);
    }

    public Message save(Message salvage){
        if(salvage.getIdMessage() == null){
            return messageRepository.save(salvage);
        }
        return salvage;
    }

    public boolean delete(int id){
        Optional<Message> messageOptional = messageRepository.getById(id);
        if(messageOptional.isPresent()){
            messageRepository.delete(messageOptional.get());
            return true;
        }
        return false;
    }

    public Message update(Message newData){
        if(newData.getIdMessage() != null){
            Optional<Message> oldData = messageRepository.getById(newData.getIdMessage());
            if(oldData.isPresent()){
                Message data = oldData.get();
                if(newData.getMessageText() != null){
                    data.setMessageText(newData.getMessageText());
                }
                return messageRepository.save(data);
            }
        }
        return newData;
    }
}
