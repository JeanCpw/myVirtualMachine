package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Audience;
import grupo3p.auditorioproyect.repository.crud.AudienceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AudienceRepository {

    @Autowired
    private AudienceCrudRepository audienceCrudRepository;

    public List<Audience> getAll(){
        return (List<Audience>) audienceCrudRepository.findAll();
    }

    public Audience save(Audience salvage){
        return audienceCrudRepository.save(salvage);
    }
}
