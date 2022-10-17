package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Score;
import grupo3p.auditorioproyect.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getById(int id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score salvage){
        return scoreCrudRepository.save(salvage);
    }

    public void delete(Score endScore){
        scoreCrudRepository.delete(endScore);
    }
}
