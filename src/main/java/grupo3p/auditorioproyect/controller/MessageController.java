package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Message;
import grupo3p.auditorioproyect.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message salvage){
        return messageService.save(salvage);
    }
}
