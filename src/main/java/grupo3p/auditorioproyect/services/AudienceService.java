package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Audience;
import grupo3p.auditorioproyect.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audiencesRepository;

    public List<Audience> getAll(){
        return audiencesRepository.getAll();
    }

    public Optional<Audience> getById(int id){
        return audiencesRepository.getById(id);
    }

    public Audience save(Audience salvage){
        if(salvage.getId() == null){
            return audiencesRepository.save(salvage);
        }
        return salvage;
    }

    public boolean delete(int id){
        Optional<Audience> audienceOptional = audiencesRepository.getById(id);
        if(audienceOptional.isPresent()){
            audiencesRepository.delete(audienceOptional.get());
            return true;
        }
        return false;
    }

    public Audience update(Audience newData){
        if(newData.getId() != null){
            Optional<Audience> oldData = audiencesRepository.getById(newData.getId());
            if(oldData.isPresent()){
                Audience data = oldData.get();
                if(newData.getName() != null){
                    data.setName(newData.getName());
                }
                if(newData.getOwner() != null){
                    data.setOwner(newData.getOwner());
                }
                if(newData.getCapacity()!= null){
                    data.setCapacity(newData.getCapacity());
                }
                if(newData.getDescription() != null){
                    data.setDescription(newData.getDescription());
                }
                return audiencesRepository.save(data);
            }
        }
        return newData;
    }
}
