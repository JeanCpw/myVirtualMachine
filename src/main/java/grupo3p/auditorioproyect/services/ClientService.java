package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Client;
import grupo3p.auditorioproyect.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getById(int id){
        return clientRepository.getById(id);
    }

    public Client save(Client salvage){
        if(salvage.getIdClient() == null){
            return clientRepository.save(salvage);
        }
        return salvage;
    }

    public boolean delete(int id){
        Optional<Client> clientOptional = clientRepository.getById(id);
        if(clientOptional.isPresent()){
            clientRepository.delete(clientOptional.get());
            return true;
        }
        return false;
    }

    public Client update(Client newData){
        if(newData.getIdClient() != null){
            Optional<Client> oldData = clientRepository.getById(newData.getIdClient());
            if(oldData.isPresent()){
                Client data = oldData.get();
                if(newData.getEmail() != null){
                    data.setEmail(newData.getEmail());
                }
                if(newData.getPassword() != null){
                    data.setPassword(newData.getPassword());
                }
                if(newData.getName() != null){
                    data.setName(newData.getName());
                }
                if(newData.getAge() != null){
                    data.setAge(newData.getAge());
                }
                return clientRepository.save(data);
            }
        }
        return newData;
    }
}

