package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Score;
import grupo3p.auditorioproyect.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Score save(Score salvage){
        return scoreCrudRepository.save(salvage);
    }
}
