package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Audience;
import grupo3p.auditorioproyect.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }

    public Audience save(Audience salvage){
        return audienceRepository.save(salvage);
    }
}
