package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Client;
import grupo3p.auditorioproyect.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Client save(Client salvage){
        return clientRepository.save(salvage);
    }
}
