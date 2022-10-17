package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Client;
import grupo3p.auditorioproyect.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getById(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client salvage){
        return clientCrudRepository.save(salvage);
    }

    public void delete(Client endClient){
        clientCrudRepository.delete(endClient);
    }
}
