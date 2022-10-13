package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Client;
import grupo3p.auditorioproyect.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Client save(Client salvage){
        return clientCrudRepository.save(salvage);
    }
}
